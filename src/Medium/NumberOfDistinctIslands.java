package Medium;

import java.util.ArrayList;
import java.util.HashSet;

public class NumberOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] check = new boolean[m][n];
        ArrayList<HashSet<String>> hsList = new ArrayList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && !check[i][j]){
                    HashSet<String> rAndc = new HashSet<>();
                    dfs(0,0,check,grid,rAndc,i,j);
                    boolean isDuplicated = false;
                    for(HashSet<String> hs : hsList){
                        if(rAndc.equals(hs)){
                            isDuplicated = true;
                            break;
                        }
                    }
                    if(!isDuplicated) hsList.add(rAndc);
                }
            }
        }
        return hsList.size();
    }
    private void dfs(int r, int c, boolean[][] check, int[][] grid, HashSet<String> rAndc, int i, int j){
        String s = r+","+c;
        rAndc.add(s);
        check[i][j] = true;
        if(i-1 >= 0 && !check[i-1][j] && grid[i-1][j] == 1){
            dfs(r-1,c,check,grid,rAndc,i-1,j);
        }
        if(j-1 >= 0 && !check[i][j-1] && grid[i][j-1] == 1){
            dfs(r,c-1,check,grid,rAndc,i,j-1);
        }
        if(i+1 < grid.length && !check[i+1][j] && grid[i+1][j] == 1){
            dfs(r+1,c,check,grid,rAndc,i+1,j);
        }
        if(j+1 < grid[0].length && !check[i][j+1] && grid[i][j+1] == 1){
            dfs(r,c+1,check,grid,rAndc,i,j+1);
        }
    }
}
