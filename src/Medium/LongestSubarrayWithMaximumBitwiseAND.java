package Medium;

public class LongestSubarrayWithMaximumBitwiseAND {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int ans = 0;
        int i = 0;
        while(i < nums.length){
            if(max <= nums[i]){
                int tempMax = nums[i];
                int count = 0;
                while(i < nums.length && nums[i] == tempMax){
                    count++;
                    i++;
                }
                if(tempMax > max) ans = count;
                else ans = Math.max(ans,count);
                max = tempMax;
            } else i++;
        }
        return ans;
    }
}
