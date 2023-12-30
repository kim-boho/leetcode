package Easy;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int ans = nums[0]*nums[1]*nums[2];
        ans = Math.max(ans, nums[0]*nums[1]*nums[len-1]);
        ans = Math.max(ans, nums[0]*nums[len-2]*nums[len-1]);
        ans = Math.max(ans, nums[len-3]*nums[len-2]*nums[len-1]);
        return ans;
    }
}
