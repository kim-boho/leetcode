package Medium;

public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3; i<=n; i++){
            int max = i-1;
            for(int j=2; j<=i/2; j++){
                int temp1 = Math.max(j,dp[j]);
                int temp2 = Math.max(i-j, dp[i-j]);
                max = Math.max(max, temp1*temp2);
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
