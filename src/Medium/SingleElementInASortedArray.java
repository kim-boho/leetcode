package Medium;

public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        return helper(nums,0,nums.length-1);
    }
    private int helper(int[] nums, int left, int right){
        if(right - left == 2){
            if(nums[left] == nums[left+1]) return nums[right];
            else return nums[left];
        } else if(right == left) return nums[left];
        int mid = left+(right-left)/2;
        if(nums[mid-1] == nums[mid]){
            if((mid-2-left)%2 == 0) return helper(nums,left,mid-2);
            else return helper(nums,mid+1,right);
        }else if(nums[mid+1] == nums[mid]){
            if((mid-1-left)%2 == 0) return helper(nums,left,mid-1);
            else return helper(nums,mid+2,right);
        } else return nums[mid];
    }
}
