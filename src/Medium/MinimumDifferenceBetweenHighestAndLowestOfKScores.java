package Medium;

import java.util.Arrays;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = nums[nums.length-1]-nums[0];
        for(int i=k-1; i<=nums.length-1; i++){
            ans = Math.min(ans,nums[i]-nums[i-k+1]);
        }
        return ans;
    }
}
