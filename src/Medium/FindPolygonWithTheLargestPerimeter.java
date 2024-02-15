package Medium;

import java.util.Arrays;

public class FindPolygonWithTheLargestPerimeter {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = (long) (nums[0]+nums[1]);
        long ans = -1;
        for(int i=2; i<nums.length; i++){
            if(sum > nums[i]) ans = sum + (long) nums[i];
            sum += (long) nums[i];
        }
        return ans;
    }
}
