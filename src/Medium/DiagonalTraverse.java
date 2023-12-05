package Medium;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m*n];
        int r = 0;
        int c = 0;
        int i = 0;
        boolean isUp = true;
        while(r < m && c < n){
            ans[i++] = mat[r][c];
            if(isUp){
                if(r-1 >= 0 && c+1 < n){
                    r--;
                    c++;
                } else{
                    if(c+1 < n){
                        c++;
                    } else{
                        r++;
                    }
                    isUp = false;
                }
            } else{
                if(r+1 < m && c-1 >= 0){
                    r++;
                    c--;
                } else{
                    if(r+1 < m){
                        r++;
                    } else{
                        c++;
                    }
                    isUp = true;
                }
            }
        }
        return ans;
    }
}
