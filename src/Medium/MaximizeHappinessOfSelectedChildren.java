package Medium;

import java.util.Arrays;

public class MaximizeHappinessOfSelectedChildren {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int count = 0;
        long ans = 0;
        for(int i=happiness.length-1; i>=0; i--){
            if(count == k) break;
            else{
                int add = happiness[i]-count++;
                if(add <= 0) break;
                ans += (long) add;
            }
        }
        return ans;
    }
}
