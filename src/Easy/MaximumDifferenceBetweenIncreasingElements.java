package Easy;

public class MaximumDifferenceBetweenIncreasingElements {
    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int ans = -1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] > min){
                ans = Math.max(ans,nums[i]-min);
            } else if(nums[i] < min){
                min = nums[i];
            }
        }
        return ans;
    }
}
