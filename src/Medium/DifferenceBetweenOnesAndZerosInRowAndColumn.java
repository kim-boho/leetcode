package Medium;

public class DifferenceBetweenOnesAndZerosInRowAndColumn {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] onesInRow = new int[m];
        int[] onesInCol = new int[n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    onesInRow[i]++;
                    onesInCol[j]++;
                }
            }
        }
        int[][] ans = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                ans[i][j] = 2*onesInRow[i]+2*onesInCol[j]-m-n;
            }
        }
        return ans;
    }
}
