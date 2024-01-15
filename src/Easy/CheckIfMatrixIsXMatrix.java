package Easy;

public class CheckIfMatrixIsXMatrix {
    public boolean checkXMatrix(int[][] grid) {
        int len = grid.length;
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if((i == j || i + j == len-1) && grid[i][j] == 0) return false;
                else if(!(i == j || i + j == len-1) && grid[i][j] != 0) return false;
            }
        }
        return true;
    }
}
