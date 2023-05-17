package Medium;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1) return;
        int idx = 0;
        boolean isReverse = true;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i+1]>nums[i]){
                idx = i;
                isReverse = false;
            }
        }
        if(isReverse){
            Arrays.sort(nums);
        } else{
            int j = -1;
            for(int i=nums.length-1; i>idx; i--){
                if(nums[i] > nums[idx]){
                    j = i;
                    break;
                }
            }
            swap(nums, idx, j);
            Arrays.sort(nums, idx+1, nums.length);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
