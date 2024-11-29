package Medium;

import java.util.Arrays;

public class FindMinimumTimeToReachLastRoom1 {
    int n;
    int m;
    public int minTimeToReach(int[][] moveTime) {
        n = moveTime.length;
        m = moveTime[0].length;
        int[][] dp = new int[n][m];
        for(int[] arr:dp) Arrays.fill(arr,Integer.MAX_VALUE);
        dfs(0,0,0,dp,moveTime);
        return dp[n-1][m-1];
    }

    private void dfs(int t, int r, int c, int[][] dp, int[][] moveTime){
        dp[r][c] = t;
        if(r-1 >= 0){
            int val = Math.max(t+1,moveTime[r-1][c]+1);
            if(dp[r-1][c] > val) dfs(val,r-1,c,dp,moveTime);
        }
        if(r+1 < n){
            int val = Math.max(t+1,moveTime[r+1][c]+1);
            if(dp[r+1][c] > val) dfs(val,r+1,c,dp,moveTime);
        }
        if(c-1 >= 0){
            int val = Math.max(t+1,moveTime[r][c-1]+1);
            if(dp[r][c-1] > val) dfs(val,r,c-1,dp,moveTime);
        }
        if(c+1 < m){
            int val = Math.max(t+1,moveTime[r][c+1]+1);
            if(dp[r][c+1] > val) dfs(val,r,c+1,dp,moveTime);
        }
    }
}
