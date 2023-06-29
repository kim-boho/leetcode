package Medium;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1) return 1;
        int[] subLen = new int[nums.length];
        Arrays.fill(subLen, 1);
        int ans = 0;
        for(int i=1; i<nums.length; i++){
            int j=0;
            while(j<i){
                if(nums[j]<nums[i]) subLen[i] = Math.max(subLen[i], subLen[j]+1);
                j++;
            }
            ans = Math.max(ans, subLen[i]);
        }
        return ans;
    }
}
