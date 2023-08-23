package Medium;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int min = 0;
        int sum = 0;
        int start = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(sum >= target){
                while(start < nums.length && sum - nums[start] >= target){
                    sum -= nums[start];
                    start++;
                }
                if(start == nums.length) return 1;
                if(min == 0) min = i-start+1;
                else min = Math.min(i-start+1, min);
            }
        }
        return min;
    }
}
