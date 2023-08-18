package Hard;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        if(nums[l]<nums[r]) return nums[l];

        while(l<r){
            int mid = (r+l)/2;
            if(mid+1<nums.length && nums[mid] > nums[mid+1]) return nums[mid+1];
            if(mid-1>=0 && nums[mid] < nums[mid-1]) return nums[mid];

            if(nums[mid] > nums[r]) l = mid+1;
            else if(nums[mid] < nums[r]) r = mid-1;
            else{
                while(r-1>=0 && nums[r-1] == nums[r]) r--;
                while(l+1<nums.length && nums[l+1] == nums[l]) l++;
            }

        }
        return nums[r];
    }
}
