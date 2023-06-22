package Medium;

public class HouseRobber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            dp[i] = nums[i];
            if(i-2>=0){
                dp[i] = Math.max(dp[i], dp[i-2]+nums[i]);
                if(i-3>=0) dp[i] = Math.max(dp[i], dp[i-3]+nums[i]);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
