package Medium;

import java.util.Arrays;

public class SumOf3Closest {
    public int threeSumClosest(int[] nums, int target) {
        int ans = 1000000;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            while(i>0 && i<nums.length-1 && nums[i-1] == nums[i]) i++;
            if(i<0 || i>nums.length-2) break;
            int picked = nums[i];
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = picked + nums[left] + nums[right];
                if(sum == target){
                    return target;
                } else if(sum > target){
                    if(Math.abs(ans-target) > Math.abs(sum-target)){
                        ans = sum;
                    }
                    right--;
                } else{
                    if(Math.abs(ans-target) > Math.abs(sum-target)){
                        ans = sum;
                    }
                    left++;
                }
            }
        }

        return ans;
    }
}
