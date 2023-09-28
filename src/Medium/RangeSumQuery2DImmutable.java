package Medium;

public class RangeSumQuery2DImmutable {
    class NumMatrix {
        int[][] sums;
        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            sums = new int[m][n];
            sums[0][0] = matrix[0][0];
            for(int i=1; i<n; i++){
                sums[0][i] = matrix[0][i]+sums[0][i-1];
            }
            for(int i=1; i<m; i++){
                sums[i][0] = matrix[i][0]+sums[i-1][0];
            }
            for(int i=1; i<m; i++){
                for(int j=1; j<n; j++){
                    sums[i][j] = sums[i-1][j]+sums[i][j-1]-sums[i-1][j-1]+matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if(row1 == 0 && col1 == 0){
                return sums[row2][col2];
            } else if(row1 == 0){
                return sums[row2][col2]-sums[row2][col1-1];
            } else if(col1 == 0){
                return sums[row2][col2]-sums[row1-1][col2];
            } else{
                return sums[row2][col2]-sums[row1-1][col2]-sums[row2][col1-1]+sums[row1-1][col1-1];
            }
        }
    }
}
