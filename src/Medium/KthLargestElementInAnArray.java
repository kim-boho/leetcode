package Medium;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        quickSelect(0, nums.length-1, nums, k);
        return nums[nums.length-k];
    }

    private void quickSelect(int start, int end, int[] nums, int k){
        int pivot = nums[end];
        int pointer = start;
        for(int i=start; i<end; i++){
            if(nums[i]<=pivot){
                int temp = nums[i];
                nums[i] = nums[pointer];
                nums[pointer] = temp;
                pointer++;
            }
        }

        nums[end] = nums[pointer];
        nums[pointer] = pivot;

        if(nums.length-k > pointer) quickSelect(pointer+1, end, nums, k);
        else if(nums.length-k < pointer) quickSelect(start, pointer-1, nums, k);
        else return;
    }
}
