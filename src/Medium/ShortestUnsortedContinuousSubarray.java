package Medium;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int start = Integer.MAX_VALUE;
        int end = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != temp[i]){
                start = Math.min(start,i);
                end = Math.max(end,i);
            }
        }
        return end == -1? 0:end-start+1;
    }
}
