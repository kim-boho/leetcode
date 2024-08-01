package Easy;

public class DetermineWhetherMatrixCanBeObtainedByRotation {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        if(checkMatrix(mat,target)) return true;
        for(int k=0; k<3; k++){
            int[][] temp = new int[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    temp[j][n-i-1] = mat[i][j];
                }
            }
            if(checkMatrix(target,temp)) return true;
            else mat = temp;
        }
        return false;
    }

    private boolean checkMatrix(int[][] m, int [][] t){
        int n = m.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(m[i][j] != t[i][j]) return false;
            }
        }
        return true;
    }
}
