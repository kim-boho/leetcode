package Easy;

public class LargestLocalValuesInAMatrix {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n-2][n-2];
        for(int i=0; i<n-2; i++){
            for(int j=0; j<n-2; j++){
                ans[i][j] = findMax(grid, i+1, j+1);
            }
        }
        return ans;
    }

    private int findMax(int[][] grid, int i, int j){
        int max = 0;
        for(int k=i-1; k<=i+1; k++){
            for(int l=j-1; l<=j+1; l++){
                if(max < grid[k][l]) max = grid[k][l];
            }
        }
        return max;
    }
}
