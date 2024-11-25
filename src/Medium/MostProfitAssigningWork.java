package Medium;

import java.util.Arrays;

public class MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        int[][] profits = new int[profit.length][2];
        for(int i=0; i<profits.length; i++){
            profits[i] = new int[]{difficulty[i],profit[i]};
        }
        Arrays.sort(profits,(a,b) -> a[0]-b[0]);
        int max = 0;
        int count = 0;
        int ans = 0;
        for (int j : worker) {
            while (count < profits.length && profits[count][0] <= j) {
                if (max < profits[count][1]) max = profits[count][1];
                count++;
            }
            ans += max;
        }
        return ans;
    }
}
