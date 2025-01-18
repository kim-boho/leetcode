package Medium;

public class CountWaysToBuildGoodStrings {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high+1];
        dp[zero]++;
        dp[one]++;
        int mod = 1000000007;
        int ans = 0;
        for(int i = Math.min(zero,one); i<dp.length; i++){
            if(i+zero < dp.length){
                dp[i+zero] += dp[i];
                dp[i+zero] %= mod;
            }
            if(i+one < dp.length){
                dp[i+one] += dp[i];
                dp[i+one] %= mod;
            }
            if(i >= low && i <= high){
                ans += dp[i];
                ans %= mod;
            }
        }
        return ans;
    }
}
