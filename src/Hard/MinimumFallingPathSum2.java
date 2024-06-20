package Hard;

public class MinimumFallingPathSum2 {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        if(n == 1) return grid[0][0];

        for(int i=0; i<n-1; i++){
            int min1 = Integer.MAX_VALUE;
            int minIdx1 = -1;
            int min2 = Integer.MAX_VALUE;
            for(int j=0; j<n; j++){
                if(grid[i][j] < min1){
                    min2 = min1;
                    min1 = grid[i][j];
                    minIdx1 = j;
                } else if(grid[i][j] < min2){
                    min2 = grid[i][j];
                }
            }
            for(int j=0; j<n; j++){
                if(j != minIdx1){
                    grid[i+1][j] += min1;
                } else{
                    grid[i+1][j] += min2;
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(grid[n-1][i] < ans) ans = grid[n-1][i];
        }
        return ans;
    }
}
