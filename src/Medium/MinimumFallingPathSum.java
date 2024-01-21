package Medium;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix){
        int n = matrix.length;
        if(n==1) return matrix[0][0];
        int ans = 10001;
        for(int i=n-2; i>=0; i--){
            for(int j=0; j<n; j++){
                int num = matrix[i][j];
                matrix[i][j] += matrix[i+1][j];
                if(j-1>=0) matrix[i][j] = Math.min(matrix[i][j], num+matrix[i+1][j-1]);
                if(j+1<n) matrix[i][j] = Math.min(matrix[i][j], num+matrix[i+1][j+1]);
                if(i==0) ans = Math.min(ans,matrix[i][j]);
            }
        }
        return ans;
    }
}
