package Medium;

public class NumberOfClosedIslands {
    boolean isClosed = true;
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        boolean[][] check = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!check[i][j] && grid[i][j] == 0){
                    isClosed = true;
                    isClosed(check,grid,i,j);
                    if(isClosed) ans++;
                }
            }
        }
        return ans;
    }

    private void isClosed(boolean[][] check, int[][] grid, int r, int c){
        check[r][c] = true;
        if(r-1 == -1 || r+1 == check.length || c-1 == -1 || c+1 == check[0].length) isClosed = false;;
        if(r-1 >= 0 && !check[r-1][c] && grid[r-1][c] == 0) isClosed(check,grid,r-1,c);
        if(c-1 >= 0 && !check[r][c-1] && grid[r][c-1] == 0) isClosed(check,grid,r,c-1);
        if(r+1 < check.length && !check[r+1][c] && grid[r+1][c] == 0) isClosed(check,grid,r+1,c);
        if(c+1 < check[0].length && !check[r][c+1] && grid[r][c+1] == 0) isClosed(check,grid,r,c+1);
    }
}
