package Medium;

public class TargetSum {
    int ans = 0;
    public int findTargetSumWays(int[] nums, int target){
        helper(nums, target, 0, 0);
        return ans;
    }

    private void helper(int[] nums, int target, int idx, int sum){
        if(idx == nums.length){
            if(target == sum) ans++;
            return;
        }
        helper(nums, target, idx+1, sum+nums[idx]);
        helper(nums, target, idx+1, sum-nums[idx]);
    }
}
