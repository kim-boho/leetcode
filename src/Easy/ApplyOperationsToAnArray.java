package Easy;

public class ApplyOperationsToAnArray {
    public int[] applyOperations(int[] nums) {
        int idx = 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] != 0){
                if(nums[i+1] == nums[i]){
                    nums[idx] = nums[i]*2;
                    nums[i+1] = 0;
                    i++;
                } else nums[idx] = nums[i];
                idx++;
            }
        }
        if(nums[nums.length-1] != 0) nums[idx++] = nums[nums.length-1];
        while(idx < nums.length) nums[idx++] = 0;
        return nums;
    }
}
