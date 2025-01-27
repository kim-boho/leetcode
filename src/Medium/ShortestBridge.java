package Medium;

import java.util.HashSet;

public class ShortestBridge {
    int rLen;
    int cLen;
    HashSet<String> hs = new HashSet<>();
    public int shortestBridge(int[][] grid) {
        int label = -1;
        rLen = grid.length;
        cLen = grid[0].length;
        for(int i=0; i<rLen; i++){
            for(int j=0; j<cLen; j++){
                if(grid[i][j] == 1){
                    checkIslands(grid,i,j,label--);
                }
            }
        }
        int count = 1;
        while(!hs.isEmpty()){
            HashSet<String> tempHs = new HashSet<>();
            for(String s:hs){
                String[] arr = s.split(",");
                int r = Integer.parseInt(arr[0]);
                int c = Integer.parseInt(arr[1]);
                grid[r][c] = count;
                if(r-1 >= 0){
                    int temp = grid[r-1][c];
                    if(temp == 0) tempHs.add((r-1)+","+c);
                    else if(temp == -2) return count;
                }
                if(c-1 >= 0){
                    int temp = grid[r][c-1];
                    if(temp == 0) tempHs.add(r+","+(c-1));
                    else if(temp == -2) return count;
                }
                if(r+1 < rLen){
                    int temp = grid[r+1][c];
                    if(temp == 0) tempHs.add((r+1)+","+c);
                    else if(temp == -2) return count;
                }
                if(c+1 < cLen){
                    int temp = grid[r][c+1];
                    if(temp == 0) tempHs.add(r+","+(c+1));
                    else if(temp == -2) return count;
                }
            }
            hs = tempHs;
            count++;
        }
        return -1;
    }

    private void validateAdjacentCell(){

    }

    private void checkIslands(int[][] grid, int r, int c, int label){
        if(r < 0 || c < 0 || r >= rLen || c >= cLen) return;
        if(grid[r][c] == 1){
            grid[r][c] = label;
            checkIslands(grid,r+1,c,label);
            checkIslands(grid,r,c+1,label);
            checkIslands(grid,r-1,c,label);
            checkIslands(grid,r,c-1,label);
        } else if (grid[r][c] == 0){
            if(label == -1) hs.add(r+","+c);
        }
    }
}
