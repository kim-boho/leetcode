package Easy;

public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 1;
        int temp = 1;
        int i = 1;
        int prev = nums[0];
        while(i < nums.length){
            if(prev < nums[i]){
                temp++;
            } else{
                if(temp > ans) ans = temp;
                temp = 1;
            }
            prev = nums[i];
            i++;
        }
        if(temp > ans) ans = temp;
        return ans;
    }
}
