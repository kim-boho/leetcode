package Easy;

import java.util.Arrays;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        if(nums.length == 1) return nums[0];
        else if(nums.length == 2) return Math.max(nums[1], nums[0]);
        else{
            int[] maxs = new int[3];
            maxs[0] = nums[0];
            int i = 1;
            while(i<nums.length && nums[i] == maxs[0]) i++;
            if(i == nums.length) return maxs[0];
            maxs[1] = nums[i];
            while(i<nums.length && (nums[i] == maxs[1] || nums[i] == maxs[0])) i++;
            if(i == nums.length) return Math.max(maxs[1], maxs[0]);
            maxs[2] = nums[i];
            Arrays.sort(maxs);
            i++;
            for(; i<nums.length; i++){
                int n = nums[i];
                if(maxs[2] < n){
                    int temp = maxs[2];
                    maxs[2] = n;
                    int temp2 = maxs[1];
                    maxs[1] = temp;
                    maxs[0] = temp2;
                } else if(maxs[2]>n && maxs[1]<n){
                    int temp = maxs[1];
                    maxs[1] = n;
                    maxs[0] = temp;
                } else if(maxs[1]>n && maxs[0]<n) maxs[0] = n;
            }
            return maxs[0];
        }
    }
}
