package Easy;

public class SortArrayByParity2 {
    public int[] sortArrayByParityII(int[] nums) {
        int i = 0;
        int j = 1;
        while(i < nums.length){
            if(nums[i] % 2 == 1){
                while(nums[j] % 2 == 1) j += 2;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
            i += 2;
        }
        return nums;
    }
}
