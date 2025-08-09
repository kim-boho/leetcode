package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslands2 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] islands = new int[m][n];
        for(int[] row:islands){
            Arrays.fill(row,-1);
        }
        List<Integer> ans = new ArrayList<>();
        int numOfIslands = 0;
        for(int[] position:positions){
            int r = position[0];
            int c = position[1];
            if(islands[r][c] != -1){
                ans.add(numOfIslands);
                continue;
            }
            ArrayList<Integer> representitiveIslands = new ArrayList<>();
            int adjacentIslandNum = checkAdjacentCell(r,c-1,m,n,islands);
            if(adjacentIslandNum != -1) representitiveIslands.add(adjacentIslandNum);
            adjacentIslandNum = checkAdjacentCell(r,c+1,m,n,islands);
            if(adjacentIslandNum != -1 && !representitiveIslands.contains(adjacentIslandNum)) representitiveIslands.add(adjacentIslandNum);
            adjacentIslandNum = checkAdjacentCell(r-1,c,m,n,islands);
            if(adjacentIslandNum != -1 && !representitiveIslands.contains(adjacentIslandNum)) representitiveIslands.add(adjacentIslandNum);
            adjacentIslandNum = checkAdjacentCell(r+1,c,m,n,islands);
            if(adjacentIslandNum != -1 && !representitiveIslands.contains(adjacentIslandNum)) representitiveIslands.add(adjacentIslandNum);
            if(representitiveIslands.isEmpty()){
                islands[r][c] = n*r+c;
                numOfIslands++;
            } else{
                int rep = representitiveIslands.get(0);
                for(int i=1; i<representitiveIslands.size(); i++){
                    int tempRep = representitiveIslands.get(i);
                    int r2 = tempRep / n;
                    int c2 = tempRep % n;
                    islands[r2][c2] = rep;
                }
                islands[r][c] = rep;
                numOfIslands -= representitiveIslands.size()-1;
            }
            ans.add(numOfIslands);
        }
        return ans;
    }

    private int checkAdjacentCell(int r, int c, int m, int n, int[][] islands){
        if(r < 0 || r >= m || c < 0 || c >= n) return -1;
        if(islands[r][c] != -1){
            return findRepIsland(islands,islands[r][c],n);
        } else return -1;
    }

    private int findRepIsland(int[][] islands, int repNum, int n){
        int r = repNum / n;
        int c = repNum % n;
        if(islands[r][c] == repNum) return repNum;
        return findRepIsland(islands,islands[r][c],n);
    }
}
