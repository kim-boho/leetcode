package Medium;

public class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int mid = nums.length/2;
        int l = 0;
        int r = nums.length-1;
        while(l <= r){
            if(nums[l]<nums[r] || l==r) return nums[l];
            if(mid > 0 && nums[mid]<nums[mid-1]) return nums[mid];
            if(mid < nums.length-1 && nums[mid]>nums[mid+1]) return nums[mid+1];
            if(nums[mid] > nums[l]) l = mid+1;
            else r= mid-1;
            mid = (l+r)/2;
        }

        return 0;
    }
}
