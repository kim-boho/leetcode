package Medium;

import java.util.Arrays;

public class FindMissingObservations {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int total = mean*(n+m);
        for(int num:rolls) total -= num;
        if(total <= 0 || total < n || total > n*6) return new int[]{};
        int[] ans = new int[n];
        for(int i=6; i>0; i--){
            if(total >= i*n){
                Arrays.fill(ans,i);
                total -= i*n;
                break;
            }
        }
        if(total == 0) return ans;
        int gap = 6-ans[0];
        for(int i=0; i<n; i++){
            if(total >= gap){
                ans[i] += gap;
                total -= gap;
            } else{
                ans[i] += total;
                break;
            }
        }
        return ans;
    }
}
