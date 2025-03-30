package Easy;

import java.util.Arrays;

public class TwoSumLessThanK {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        int sum = 0;
        while(i < j){
            if(nums[i]+nums[j] >= k) j--;
            else{
                while(i < j && nums[i]+nums[j] < k) i++;
                sum = Math.max(sum,nums[i-1]+nums[j]);
                j--;
            }
        }
        return sum == 0? -1:sum;
    }
}
