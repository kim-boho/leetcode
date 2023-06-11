package Medium;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int preMax = nums[0];
        int preMin = nums[0];
        int ans = nums[0];
        for(int i=1; i<nums.length; i++){
            int tempMax = nums[i]*preMax;
            int tempMin = nums[i]*preMin;
            preMax = Math.max(Math.max(tempMax, tempMin), nums[i]);
            preMin = Math.min(Math.min(tempMax, tempMin), nums[i]);
            ans = Math.max(ans, preMax);
        }

        return ans;
    }
}
