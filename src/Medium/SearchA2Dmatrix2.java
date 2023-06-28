package Medium;

public class SearchA2Dmatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length; int m = matrix[0].length;
        int i = 0; int j = m-1;
        while(i<n && j>=0){
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] < target) i++;
            else j--;
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++){
            int temp = binarySearchRow(matrix[i], target);
            if(temp != -1) return true;
        }
        return false;
    }

    private int binarySearchRow(int[] row, int target){
        int start = 0;
        int end = row.length-1;
        int mid = row.length/2;
        while(start<=end){
            if(row[mid] == target){
                return mid;
            } else if(row[mid] > target){
                end = mid-1;
            } else{
                start = mid+1;
            }
            mid = (start+end)/2;
        }
        return -1;
    }
}
