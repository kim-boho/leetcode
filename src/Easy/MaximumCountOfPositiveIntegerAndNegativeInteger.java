package Easy;

public class MaximumCountOfPositiveIntegerAndNegativeInteger {
    public int maximumCount(int[] nums) {
        if(nums.length == 1) return nums[0] == 0? 0:1;
        if(nums[0] == 0 && nums[nums.length-1] == 0) return 0;
        if(nums[0] > 0 || nums[nums.length-1] < 0) return nums.length;
        int l = 0;
        int r = nums.length-1;
        int mid = (l+r)/2;
        int ans = 0;
        while(l<=r){
            if(nums[mid] < 0 && nums[mid+1] >= 0){
                ans = mid+1;
                break;
            }
            if(nums[mid] < 0){
                l = mid+1;
            } else{
                r = mid-1;
            }
            mid = (l+r)/2;
        }
        l = mid+1;
        r = nums.length-1;
        mid = (l+r)/2;
        while(l<=r){
            if(nums[mid] > 0 && nums[mid-1] <= 0){
                ans = Math.max(ans,nums.length-mid);
                break;
            }
            if(nums[mid] <= 0){
                l = mid+1;
            } else{
                r = mid-1;
            }
            mid = (l+r)/2;
        }
        return ans;
    }
}
