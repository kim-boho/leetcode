package Medium;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int i=0;
        int j=i+1;
        while(j<nums.length && nums[i]<nums[j]){
            i++;
            j++;
        }

        if(target>=nums[0] && target<=nums[i]){
            return binarySearch(nums, 0, i, target);
        } else if(j<nums.length && target>=nums[j] && target<=nums[nums.length-1]){
            return binarySearch(nums, j, nums.length-1, target);
        }

        return -1;
    }

    private int binarySearch(int[] arr, int start, int end, int target){
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid] == target){
                return mid;
            } else if(arr[mid]>target){
                end = mid-1;
            } else if(arr[mid]<target){
                start = mid+1;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(mid == start || mid == end){
                if(nums[start] == target) return start;
                else if(nums[end] == target) return end;
            }

            if(nums[mid] == target){
                return mid;
            } else if(nums[start] < nums[mid]){
                if(nums[mid] >= target && nums[start] <= target) end = mid-1;
                else start = mid+1;
            } else{
                if(nums[mid] <= target && nums[end] >= target) start = mid+1;
                else end = mid-1;
            }
        }
        return -1;
    }
}
