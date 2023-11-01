package Medium;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElements2 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = 0;
        if(nums.length % 2 == 0){
            mid = (nums[nums.length/2]+nums[nums.length/2-1])/2;
        } else{
            mid = nums[nums.length/2];
        }
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            ans += Math.abs(mid-nums[i]);
        }
        return ans;
    }
}
