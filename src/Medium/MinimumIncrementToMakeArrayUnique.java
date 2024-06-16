package Medium;

import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[0];
        int ans = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i] <= prev){
                ans += prev-nums[i]+1;
                nums[i] = prev+1;
            }
            prev = nums[i];
        }
        return ans;
    }
}
