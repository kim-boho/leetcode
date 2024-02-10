package Medium;

import java.util.Arrays;

public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    public int minDifference(int[] nums) {
        if(nums.length < 5) return 0;
        else{
            Arrays.sort(nums);
            int lastIdx = nums.length-1;
            int ans = nums[lastIdx]-nums[0];
            if(nums[lastIdx]-nums[3] < ans) ans = nums[lastIdx]-nums[3];
            if(nums[lastIdx-3]-nums[0] < ans) ans = nums[lastIdx-3]-nums[0];
            if(nums[lastIdx-1]-nums[2] < ans) ans = nums[lastIdx-1]-nums[2];
            if(nums[lastIdx-2]-nums[1] < ans) ans = nums[lastIdx-2]-nums[1];
            return ans;
        }
    }
}
