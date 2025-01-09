package Easy;

public class FinalPricesWithASpecialDiscountInAShop {
    public int[] finalPrices(int[] prices) {
        int len = prices.length;
        int[] ans = new int[len];
        for(int i=0; i<len; i++){
            int j = i+1;
            int n = prices[i];
            while(j<len && prices[j] > n) j++;
            if(j < len){
                ans[i] = prices[i]-prices[j];
            } else ans[i] = prices[i];
        }
        return ans;
    }
}
