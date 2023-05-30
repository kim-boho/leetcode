package Medium;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int minPrice = prices[0];
        for(int i=1; i<prices.length; i++){
            if(prices[i]-minPrice > ans) ans = prices[i]-minPrice;
            minPrice = Math.min(minPrice, prices[i]);
        }
        return ans;
    }
}
