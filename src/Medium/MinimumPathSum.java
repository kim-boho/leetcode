package Medium;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] weight = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(j-1>=0 && i-1>=0){
                    weight[i][j] = Math.min(weight[i-1][j]+grid[i][j], weight[i][j-1]+grid[i][j]);
                } else if(i-1>=0){
                    weight[i][j] = weight[i-1][j]+grid[i][j];
                } else if(j-1>=0){
                    weight[i][j] =  weight[i][j-1]+grid[i][j];
                } else{
                    weight[i][j] = grid[i][j];
                }
            }
        }

        return weight[n-1][m-1];
    }
}
