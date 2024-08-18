package Medium;

public class MaximumNumberOfPointsWithCost {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] dp = new long[n];
        for (int[] point : points) {
            for (int j = 0; j < n; j++) {
                dp[j] += point[j];
            }
            for (int j = 1; j < n; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1] - 1);
            }
            for (int j = n - 2; j >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j + 1] - 1);
            }
        }

        long ans = 0;
        for(long l:dp){
            ans = Math.max(ans,l);
        }
        return ans;
    }
}
