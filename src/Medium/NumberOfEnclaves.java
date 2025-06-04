package Medium;

public class NumberOfEnclaves {
    boolean isInside = true;
    int count  = 0 ;
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] check = new boolean[m][n];
        int ans = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && !check[i][j]){
                    isInside = true;
                    count = 0;
                    dfs(i,j,check,grid);
                    if(isInside) ans += count;
                }
            }
        }
        return ans;
    }

    private void dfs(int r, int c, boolean[][] check, int[][] grid){
        check[r][c] = true;
        count++;
        if(r == 0 || r == check.length-1 || c == 0 || c == check[0].length-1) isInside = false;
        if(r-1 >= 0 && grid[r-1][c] == 1 && !check[r-1][c]) dfs(r-1,c,check,grid);
        if(c-1 >= 0 && grid[r][c-1] == 1 && !check[r][c-1]) dfs(r,c-1,check,grid);
        if(r+1 < check.length && grid[r+1][c] == 1 && !check[r+1][c]) dfs(r+1,c,check,grid);
        if(c+1 < check[0].length && grid[r][c+1] == 1 && !check[r][c+1]) dfs(r,c+1,check,grid);
    }
}
