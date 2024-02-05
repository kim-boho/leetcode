package Medium;

import java.util.HashMap;

public class MinimumOperationsToReduceXToZero {
    public int minOperations(int[] nums, int x) {
        int len = nums.length;
        int i = len - 1;
        int sum = 0;
        HashMap<Integer, Integer> sums = new HashMap();
        int ans = len + 1;
        while (sum <= x && i >= 0) {
            sum += nums[i];
            if (sum == x) ans = Math.min(ans, len - i);
            sums.put(sum, i);
            i--;
        }
        int j = 0;
        int sum2 = 0;
        while (j < len) {
            sum2 += nums[j];
            if (sum2 == x) ans = Math.min(ans, j + 1);
            if (sum2 > x) break;
            if (sums.containsKey(x - sum2)) {
                ans = Math.min(ans, j + 1 + (len - sums.get(x - sum2)));
            }
            j++;
        }
        return ans == len + 1 ? -1 : ans;
    }
}
