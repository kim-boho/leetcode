package Medium;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {

        // num of coins to sum 1~amount
        int[] dp = new int[amount+1];

        // set max int that it can have to sum i
        for(int i=0; i<dp.length; i++) dp[i] = amount+1;
        dp[0] = 0;

        for(int i=0; i<dp.length; i++){
            for(int coin:coins){
                if(i-coin >= 0) dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }

        return dp[amount] == amount+1 ? -1:dp[amount];
    }
}
