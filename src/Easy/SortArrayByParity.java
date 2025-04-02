package Easy;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int i=0;
        int j=nums.length-1;
        while(i  < j){
            if(nums[j] % 2 ==  0){
                while(i<j  &&  nums[i]%2 != 1) i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
                i++;
            } else j--;
        }
        return nums;
    }
}
