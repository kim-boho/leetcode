package Medium;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int[] ans = {-1,-1};
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid] == target){
                int left = mid;
                int right = mid;
                while(left-1>=0 && nums[left-1] == target) left--;
                while(right+1<nums.length && nums[right+1] == target) right++;
                ans[0] = left;
                ans[1] = right;
                return ans;
            } else if(nums[mid]<target){
                start = mid+1;
            } else if(nums[mid]>target){
                end = mid-1;
            }
        }
        return ans;
    }
}
