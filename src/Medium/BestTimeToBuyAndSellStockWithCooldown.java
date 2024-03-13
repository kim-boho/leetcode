package Medium;

public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2) return 0;
        int boughtAndHolding = -prices[0];
        int sold = 0;
        int wasCoolDown = 0;
        for(int i=1; i<len; i++){
            int p = prices[i];
            int tempBoughtAndHolding = Math.max(boughtAndHolding, wasCoolDown-p);
            int tempSold = Math.max(sold, boughtAndHolding + p);
            int tempInCoolDown = sold;
            boughtAndHolding = tempBoughtAndHolding;
            sold = tempSold;
            wasCoolDown = tempInCoolDown;
        }
        return Math.max(boughtAndHolding, Math.max(sold, wasCoolDown));
    }
}
