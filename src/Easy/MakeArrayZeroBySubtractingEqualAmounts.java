package Easy;

import java.util.Arrays;

public class MakeArrayZeroBySubtractingEqualAmounts {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int addNum = 0;
        int ans = 0;
        int prev = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == prev) continue;
            else{
                prev = nums[i];
                ans++;
                addNum += (nums[i]-addNum);
                if(addNum >= nums[nums.length-1]) break;
            }
        }
        return ans;
    }
}
