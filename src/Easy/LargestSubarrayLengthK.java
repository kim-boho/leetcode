package Easy;

import java.util.Arrays;

public class LargestSubarrayLengthK {
    public int[] largestSubarray(int[] nums, int k) {
        int max = nums[0];
        int idx = 0;
        for(int i=1; i<nums.length-k+1; i++){
            if(max < nums[i]){
                max = nums[i];
                idx = i;
            }
        }
        return Arrays.copyOfRange(nums, idx, idx+k);
    }
}
