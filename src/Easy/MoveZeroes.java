package Easy;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int numIdx = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                numIdx = Math.max(i+1, numIdx);
                while(numIdx < nums.length && nums[numIdx] == 0) numIdx++;
                if(numIdx == nums.length) break;
                nums[i] = nums[numIdx];
                nums[numIdx] = 0;
            }
        }
        return;
    }
}
