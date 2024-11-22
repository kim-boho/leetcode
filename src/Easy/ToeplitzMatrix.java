package Easy;

public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(m == 1 || n == 1) return true;
        for(int i=m-2; i>0; i--){
            int prev = matrix[i][0];
            for(int j=1; j+i<m && j<n; j++){
                if(matrix[i+j][j] != prev) return false;
            }
        }
        for(int i=0; i<n; i++){
            int prev = matrix[0][i];
            for(int j=1; j<Math.min(m,n-i); j++){
                if(matrix[j][j+i] != prev) return false;
            }
        }
        return true;
    }
}
