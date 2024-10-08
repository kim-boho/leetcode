package Easy;

import java.util.Arrays;

public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=n-1; i>1; i--){
            if(nums[i]<nums[i-1]+nums[i-2]) return nums[i]+nums[i-1]+nums[i-2];
        }
        return 0;
    }
}
