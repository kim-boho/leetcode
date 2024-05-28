package Easy;

import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanOrEqualX {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int pointer = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[nums.length-i-1] < i && nums[nums.length-i] >= i) return i;
        }
        int start = nums[0];
        while(start > 0){
            if(start == nums.length) return nums.length;
            start--;
        }
        return -1;
    }
}
