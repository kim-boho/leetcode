package Medium;

public class CoinChange {
    int ans = -1;
    public int coinChange(int[] coins, int amount) {
        dp(coins, 0, amount);
        return ans;
    }

    private void dp(int[] coins, int count, int amount){
        if(amount == 0){
            if(ans == -1) ans = count;
            else ans = Math.min(ans, count);
        } else{
            for(int i=0; i<coins.length; i++){
                if(amount-coins[i] >= 0){
                    dp(coins, count+1, amount-coins[i]);
                }
            }
        }
    }
}
