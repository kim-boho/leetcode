package Hard;

import java.util.Arrays;

public class LongestIncreasingPathInAMatrix {
    int m;
    int n;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int[][] nums = new int[m*n][2];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                nums[i*n+j] = new int[] {matrix[i][j], i*n+j};
            }
        }
        Arrays.sort(nums,(a, b) -> b[0]-a[0]);
        int[][] dp = new int[m][n];
        for(int[] arr:nums){
            int c = arr[1] % n;
            int r = (arr[1]-c) / n;
            if(dp[r][c] == 0){
                boolean[][] check = new boolean[m][n];
                dfs(dp,matrix,check,1,r,c);
            }
        }
        int ans = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                ans = Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }

    private void dfs(int[][] dp, int[][] matrix, boolean[][] check, int depth, int r, int c){
        check[r][c] = true;
        int curr = matrix[r][c];
        int max = 0;
        if(r-1 >= 0 && curr < matrix[r-1][c] && !check[r-1][c]){
            if(dp[r-1][c] == 0){
                dfs(dp, matrix, check, depth+1, r-1, c);
            } else{
                max = Math.max(dp[r-1][c],max);
            }
        }
        if(r+1 < m && curr < matrix[r+1][c] && !check[r+1][c]){
            if(dp[r+1][c] == 0){
                dfs(dp, matrix, check, depth+1, r+1, c);
            } else{
                max = Math.max(dp[r+1][c],max);
            }
        }
        if(c-1 >= 0 && curr < matrix[r][c-1] && !check[r][c-1]){
            if(dp[r][c-1] == 0){
                dfs(dp, matrix, check, depth+1, r, c-1);
            } else{
                max = Math.max(dp[r][c-1],max);
            }
        }
        if(c+1 < n && curr < matrix[r][c+1] && !check[r][c+1]){
            if(dp[r][c+1] == 0){
                dfs(dp, matrix, check, depth+1, r, c+1);
            } else{
                max = Math.max(dp[r][c+1],max);
            }
        }
        dp[r][c] = max+depth;
        check[r][c] = false;
    }
}
