package Hard;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(i+1 == nums[i]) continue;
            while(nums[i]>0 && nums[i]<=nums.length){
                if(i+1 == nums[i]) break;
                if(nums[i] == nums[nums[i]-1]){
                    nums[i] = -1;
                } else{
                    int temp = nums[nums[i]-1];
                    nums[nums[i]-1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] != i+1) return i+1;
        }

        return nums.length+1;
    }
}
