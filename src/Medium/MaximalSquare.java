package Medium;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == '1'){
                    if(ans == 0) ans = 1;
                    int x = i+1;
                    int y = j+1;
                    int len = 2;
                    while(x < m && y < n){
                        boolean isValid = true;
                        for(int k=i; k<=x; k++){
                            if(matrix[k][y] == '0'){
                                isValid = false;
                                break;
                            }
                        }
                        for(int k=j; k<=y; k++){
                            if(matrix[x][k] == '0'){
                                isValid = false;
                                break;
                            }
                        }
                        if(isValid){
                            ans = Math.max(ans,len++);
                            x++;
                            y++;
                        } else break;
                    }
                }
            }
        }
        return ans*ans;
    }
}
