package Medium;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if(len == 1 || nums[0] > nums[1]) return 0;
        else if(nums[len-1] > nums[len-2]) return len-1;
        int left = 1;
        int right = len-2;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
            else if(nums[mid] > nums[mid-1]) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }
}
