package Medium;

public class SortAnArray {
    public int[] sortArray(int[] nums) {
        sort(0,nums.length-1,nums);
        return nums;
    }

    private void sort(int start, int end, int[] nums){
        if(start == end) return;
        int mid = (start+end) / 2;
        sort(start,mid,nums);
        sort(mid+1,end,nums);
        int l = start;
        int r = mid+1;
        int idx = 0;
        int[] temp = new int[end-start+1];
        while(l<=mid && r<=end){
            if(nums[l]<nums[r]){
                temp[idx++] = nums[l++];
            } else{
                temp[idx++] = nums[r++];
            }
        }
        while(l<=mid){
            temp[idx++] = nums[l++];
        }
        while(r<=end){
            temp[idx++] = nums[r++];
        }
        for (int j : temp) {
            nums[start++] = j;
        }
    }
}
