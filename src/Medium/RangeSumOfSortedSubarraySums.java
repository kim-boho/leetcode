package Medium;

import java.util.Arrays;

public class RangeSumOfSortedSubarraySums {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] sums = new int[n*(n+1)/2];
        int idx = 0;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += nums[j];
                sums[idx++] = sum;
            }
        }
        Arrays.sort(sums);
        int ans = 0;
        int mod = 1000000007;
        for(int i=left-1; i<right; i++){
            ans += sums[i];
            ans %= mod;
        }
        return ans;
    }
}
