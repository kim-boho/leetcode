package Medium;

import java.util.Arrays;

public class ReductionOperationsToMakeTheArrayElementsEqual {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int ans = 0;
        for(int i=len-1; i>0; i--){
            if(nums[i-1] != nums[i]){
                ans += (len-i);
            }
        }
        return ans;
    }
}
