package Medium;

import java.util.Arrays;

public class FindSubsequenceOfLengthKWithTheLargestSum {
    public int[] maxSubsequence(int[] nums, int k) {
        int[][] sorted = new int[nums.length][2];
        for(int i=0; i<nums.length; i++){
            sorted[i][0] = nums[i];
            sorted[i][1] = i;
        }
        Arrays.sort(sorted,(a, b) -> a[0]-b[0]);
        int[][] withIdx = new int[k][2];
        System.arraycopy(sorted, nums.length-k, withIdx, 0, k);
        Arrays.sort(withIdx,(a,b) -> a[1]-b[1]);
        int[] ans = new int[k];
        for(int i=0; i<withIdx.length; i++){
            ans[i] = withIdx[i][0];
        }
        return ans;
    }
}
