package Medium;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // O(m+n)
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0; i<m; i++){
            if(matrix[i][0]<=target && matrix[i][n-1]>=target){
                for(int j=0; j<n; j++){
                    if(matrix[i][j] == target) return true;
                }
                return false;
            }
            if(i+1<m && matrix[i+1][0]>target) return false;
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        // O(log(m*n))
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m*n-1;

        while(left <= right){
            int mid = (left+right)/2;
            int row = mid / n;
            int col = mid % n;;
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target){
                right = mid-1;
            } else{
                left = mid+1;
            }
        }
        return false;
    }
}
