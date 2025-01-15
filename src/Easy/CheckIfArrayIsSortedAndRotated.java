package Easy;

public class CheckIfArrayIsSortedAndRotated {
    public boolean check(int[] nums) {
        int i = 1;
        while(i < nums.length && nums[i] >= nums[i-1]) i++;
        if(i == nums.length) return true;
        i++;
        while(i < nums.length && nums[i] >= nums[i-1]) i++;
        if(i != nums.length) return false;
        else{
            if(nums[0] < nums[nums.length-1]) return false;
            return true;
        }
    }
}
