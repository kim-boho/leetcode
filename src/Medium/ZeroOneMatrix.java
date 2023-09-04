package Medium;

import java.util.ArrayList;

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        int count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1) ans[i][j] = m+n;
            }
        }
        int idx = 0;
        while(count < m*n){
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(ans[i][j] == idx){
                        count++;
                        if(i-1>=0 && mat[i-1][j] == 1 && ans[i-1][j] > idx+1){
                            ans[i-1][j] = idx+1;
                        }
                        if(i+1<m && mat[i+1][j] == 1 && ans[i+1][j] > idx+1){
                            ans[i+1][j] = idx+1;
                        }
                        if(j-1>=0 && mat[i][j-1] == 1 && ans[i][j-1] > idx+1){
                            ans[i][j-1] = idx+1;
                        }
                        if(j+1<n && mat[i][j+1] == 1 && ans[i][j+1] > idx+1){
                            ans[i][j+1] = idx+1;
                        }
                    }
                }
            }
            idx++;
        }
        return ans;
    }
}
