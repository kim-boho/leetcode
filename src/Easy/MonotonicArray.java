package Easy;

public class MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        if(nums.length == 1) return true;
        boolean isIncreasing = true;
        int i = 1;
        while(i<nums.length && nums[i-1] == nums[i]) i++;
        if(i == nums.length) return true;
        if(nums[i] < nums[i-1]) isIncreasing = false;
        int prev = nums[i];
        for(int j=i+1; j<nums.length; j++){
            if(isIncreasing && nums[j]<prev) return false;
            if(!isIncreasing && nums[j]>prev) return false;
            prev = nums[j];
        }
        return true;
    }
}
