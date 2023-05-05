package Medium;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
        int prevMax = nums[0];
        int idx = 1;
        int max = prevMax;
        while(idx<nums.length){

            int tempMax = 0;
            if(nums[idx] > 0 && prevMax <= 0) tempMax = nums[idx];
            else if(nums[idx] > 0 && prevMax > 0) tempMax = prevMax + nums[idx];
            else if(nums[idx] <= 0 && prevMax <= 0) tempMax = nums[idx];
            else {tempMax = prevMax + nums[idx];}

            max = Math.max(max, tempMax);
            prevMax = tempMax;
            idx++;
        }
        return max;
    }
}
