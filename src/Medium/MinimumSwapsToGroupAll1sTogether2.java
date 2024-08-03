package Medium;

public class MinimumSwapsToGroupAll1sTogether2 {
    public int minSwaps(int[] nums) {
        int len = nums.length;
        int[] preSum = new int[len];
        int ones = 0;
        if(nums[0] == 1){
            preSum[0] = 1;
            ones++;
        }
        for(int i=1; i<len; i++){
            if(nums[i] == 1){
                preSum[i] = preSum[i-1]+1;
                ones++;
            }
            else preSum[i] = preSum[i-1];
        }
        if(ones == 0) return 0;
        int ans = ones-preSum[ones-1];

        for(int i=1; i<len; i++){
            int j = i+ones-1;
            if(j >= len){
                j %= len;
                ans = Math.min(ans, ones-(preSum[len-1]-preSum[i-1]+preSum[j]));
            } else{
                ans = Math.min(ans, ones-(preSum[j]-preSum[i-1]));
            }
        }
        return ans;
    }
}
