package Medium;

import java.util.Arrays;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int k = s3.length();
        if(m+n != k) return false;

        int[][] path = new int[n+1][m+1];
        for(int[] arr: path) Arrays.fill(arr, -1);

        for(int i=1; i<=m; i++){
            if(s1.charAt(i-1) == s3.charAt(i-1)) path[0][i] = i-1;
            else break;
        }

        for(int j=1; j<=n; j++){
            if(s2.charAt(j-1) == s3.charAt(j-1)) path[j][0] = j-1;
            else break;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(path[i-1][j] != -1 && s2.charAt(i-1) == s3.charAt(path[i-1][j]+1)){
                    path[i][j] = path[i-1][j]+1;
                } else if(path[i][j-1] != -1 && s1.charAt(j-1) == s3.charAt(path[i][j-1]+1)){
                    path[i][j] = path[i][j-1]+1;
                }
            }
        }
        return path[n][m] == k-1? true:false;
    }
}
