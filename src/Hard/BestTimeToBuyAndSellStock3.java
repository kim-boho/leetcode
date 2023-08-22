package Hard;

public class BestTimeToBuyAndSellStock3 {
    public int maxProfit(int[] prices) {
        int[] leftSide = new int[prices.length];
        int[] rightSide = new int[prices.length];
        int min = prices[0];

        for(int i=1; i<prices.length; i++) {
            if(prices[i] - min > leftSide[i-1]) leftSide[i] = prices[i] - min;
            else leftSide[i] = leftSide[i-1];
            min = Math.min(min, prices[i]);
        }

        int ans = 0;
        int max = prices[prices.length-1];
        for(int i=prices.length-2; i>=0; i--) {
            if(max - prices[i] > rightSide[i+1]) rightSide[i] = max - prices[i];
            else rightSide[i] = rightSide[i+1];
            max = Math.max(max, prices[i]);
            ans = Math.max(ans, rightSide[i]+leftSide[i]);
        }

        return ans;
    }
}
