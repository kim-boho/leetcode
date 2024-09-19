package Medium;

public class ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] ones = new int[n];
        int[] zeroes = new int[n];
        for(int i=0; i<m; i++){
            if(grid[i][0] == 0) flip(grid[i],ones,zeroes);
            else{
                for(int j=0; j<grid[i].length; j++){
                    if(grid[i][j] == 0) zeroes[j]++;
                    else ones[j]++;
                }
            }
        }
        int times = 1;
        int ans = 0;
        for(int i=n-1; i>=0; i--){
            ans += times*Math.max(ones[i],zeroes[i]);
            times *= 2;
        }
        return ans;
    }

    private void flip(int[] grid, int[] ones, int[] zeroes){
        for(int i=0; i<grid.length; i++){
            if(grid[i] == 0){
                grid[i]++;
                ones[i]++;
            } else{
                grid[i]--;
                zeroes[i]++;
            }
        }
    }
}
