package Medium;

public class HouseRobber2 {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp = new int[nums.length];
        int ans = 0;
        for(int i=0; i<nums.length-1; i++){
            int temp = 0;
            if(i-3>=0){
                temp = Math.max(dp[i-3], dp[i-2]);
            } else if(i-2>=0){
                temp = dp[i-2];
            }
            dp[i] = nums[i] + temp;
            if(ans < dp[i]) ans = dp[i];
        }
        for(int i=nums.length-1; i>0; i--){
            int temp = 0;
            if(i+3<nums.length){
                temp = Math.max(dp[i+3], dp[i+2]);
            } else if(i+2<nums.length){
                temp = dp[i+2];
            }
            dp[i] = nums[i] + temp;
            if(ans < dp[i]) ans = dp[i];
        }
        return ans;
    }
}
