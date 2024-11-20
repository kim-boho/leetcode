package Medium;

public class MinimumAdjacentSwapsToMakeAValidArray {
    public int minimumSwaps(int[] nums) {
        int min = nums[0];
        int minIdx = 0;
        int max = nums[0];
        int maxIdx = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i] < min){
                min = nums[i];
                minIdx = i;
            } else if(nums[i] >= max){
                max = nums[i];
                maxIdx = i;
            }
        }
        if(min == max) return 0;
        int ans = nums.length-maxIdx-1+minIdx;
        return minIdx < maxIdx ? ans:ans-1;
    }
}
