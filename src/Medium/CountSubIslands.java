package Medium;

import java.util.HashMap;

public class CountSubIslands {
    boolean tempBoolean;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int label = 1;
        boolean[][] check = new boolean[m][n];
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid1[i][j] == 1 && !check[i][j]){
                    checkIslands(i,j,check,grid1,hm,m,n,label);
                    label++;
                }
            }
        }

        check = new boolean[m][n];
        int ans = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid2[i][j] == 1 && !check[i][j]){
                    tempBoolean = true;
                    int tempLabel = -1;
                    if(hm.containsKey(n*i+j)) tempLabel = hm.get(n*i+j);
                    checkIslands2(i,j,check,grid2,hm,m,n,tempLabel);
                    if(tempBoolean) ans++;
                }
            }
        }
        return ans;
    }

    private void checkIslands(int i, int j, boolean[][] check, int[][] grid, HashMap <Integer, Integer> hm, int m, int n, int label){
        check[i][j] = true;
        hm.put(n*i+j,label);
        if(i-1 >= 0 && grid[i-1][j] == 1 && !check[i-1][j]) checkIslands(i-1, j, check, grid, hm, m, n, label);
        if(j-1 >= 0 && grid[i][j-1] == 1 && !check[i][j-1]) checkIslands(i, j-1, check, grid, hm, m, n, label);
        if(i+1 < m && grid[i+1][j] == 1 && !check[i+1][j]) checkIslands(i+1, j, check, grid, hm, m, n, label);
        if(j+1 < n && grid[i][j+1] == 1 && !check[i][j+1]) checkIslands(i, j+1, check, grid, hm, m, n, label);
    }

    private void checkIslands2(int i, int j, boolean[][] check, int[][] grid, HashMap <Integer, Integer> hm, int m, int n, int label){
        check[i][j] = true;
        int num = n*i+j;
        if(!hm.containsKey(num) || hm.get(num) != label) tempBoolean = false;
        if(i-1 >= 0 && grid[i-1][j] == 1 && !check[i-1][j]) checkIslands2(i-1, j, check, grid, hm, m, n, label);
        if(j-1 >= 0 && grid[i][j-1] == 1 && !check[i][j-1]) checkIslands2(i, j-1, check, grid, hm, m, n, label);
        if(i+1 < m && grid[i+1][j] == 1 && !check[i+1][j]) checkIslands2(i+1, j, check, grid, hm, m, n, label);
        if(j+1 < n && grid[i][j+1] == 1 && !check[i][j+1]) checkIslands2(i, j+1, check, grid, hm, m, n, label);
    }
}
