package Medium;

import java.util.Arrays;

public class MaximumNumberOfCoinsYouCanGet {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int i = piles.length-2;
        int left = 0;
        int ans = 0;
        while(left < i){
            ans += piles[i];
            i -= 2;
            left++;
        }

        return ans;
    }
}
