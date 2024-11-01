package Medium;

import java.util.Arrays;

public class MiceAndCheese {
    public int miceAndCheese(int[] r1, int[] r2, int k) {
        int ans = 0;
        int len = r1.length;
        int[] diff = new int[len];
        for(int i=0; i<len; i++){
            diff[i] = r1[i]-r2[i];
            ans += r2[i];
        }
        Arrays.sort(diff);
        for(int i=0; i<k; i++){
            ans += diff[len-i-1];
        }
        return ans;
    }
}
