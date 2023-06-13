package Medium;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] temp = new int[nums.length];
        for(int i=0; i<k; i++) temp[i] = nums[nums.length-k+i];
        for(int i=k; i<nums.length; i++) temp[i] = nums[i-k];
        for(int i=0; i<nums.length; i++) nums[i] = temp[i];
    }
}
