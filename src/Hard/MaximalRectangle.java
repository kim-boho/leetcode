package Hard;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int ans = 0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(matrix[i][j] == '1'){
                    int lastR = i;
                    int lastC = j;
                    while(lastR < r && matrix[lastR][j] != '0') lastR++;
                    while(lastC < c && matrix[i][lastC] != '0') lastC++;
                    for(int k=i; k<lastR; k++){
                        for(int m=j; m<lastC; m++){
                            if(matrix[k][m] == '1'){
                                ans = Math.max(ans, (k-i+1)*(m-j+1));
                            } else{
                                lastC = m;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
