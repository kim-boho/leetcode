package Easy;

import java.util.Arrays;

public class MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        for(; i<nums.length && k>0; i++){
            if(nums[i] >= 0) break;
            else{
                nums[i] *= -1;
                k--;
            }
        }
        if(i != 0) i--;
        if(i+1 < nums.length){
            if(nums[i+1] < nums[i]) i++;
        }
        if(k % 2 == 1) nums[i] *= -1;
        int ans = 0;
        for(int n:nums) ans += n;
        return ans;
    }
}
