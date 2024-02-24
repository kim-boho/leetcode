package Medium;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {
    public int minPairSum(int[] nums) {
        int maxSum = 0;
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        while(i < j){
            maxSum = Math.max(nums[i++]+nums[j--], maxSum);
        }
        return maxSum;
    }
}
