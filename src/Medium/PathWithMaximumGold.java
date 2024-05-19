package Medium;

public class PathWithMaximumGold {
    int ans = 0;
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] check = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] != 0) helper(grid, i, j, 0, check, m, n);
            }
        }
        return ans;
    }

    private void helper(int[][] grid, int i, int j, int sum, boolean[][] check, int m, int n){
        if(grid[i][j] == 0)  return;
        if(ans < sum+grid[i][j]) ans = sum+grid[i][j];
        check[i][j] = true;
        if(i-1 >= 0 && !check[i-1][j]){
            check[i-1][j] = true;
            helper(grid, i-1, j, sum+grid[i][j], check, m, n);
            check[i-1][j] = false;
        }
        if(j-1 >= 0 && !check[i][j-1]){
            check[i][j-1] = true;
            helper(grid, i, j-1, sum+grid[i][j], check, m, n);
            check[i][j-1] = false;
        }
        if(i+1 < m && !check[i+1][j]){
            check[i+1][j] = true;
            helper(grid, i+1, j, sum+grid[i][j], check, m, n);
            check[i+1][j] = false;
        }
        if(j+1 < n && !check[i][j+1]){
            check[i][j+1] = true;
            helper(grid, i, j+1, sum+grid[i][j], check, m, n);
            check[i][j+1] = false;
        }
        check[i][j] = false;
    }
}
