package Medium;

public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int[] prefixMax = new int[nums.length];
        int[] prefixSum = new int[nums.length];
        prefixMax[0] = nums[0];
        prefixSum[0] = nums[0];

        for(int i=1; i<nums.length; i++){
            prefixSum[i] = prefixSum[i-1]+nums[i];
            prefixMax[i] = Math.max(prefixMax[i-1], prefixSum[i]);
        }

        int ans = prefixMax[nums.length-1];

        for(int i=1; i<nums.length; i++){
            ans = Math.max(prefixSum[nums.length-1]-prefixSum[i-1]+prefixMax[i-1],ans);
        }

        for(int i=1; i<nums.length; i++){
            for(int j=i; j<nums.length; j++){
                ans = Math.max(ans, prefixSum[j]-prefixSum[i-1]);
            }
        }

        return ans;
    }
}
