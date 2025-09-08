package Medium;

import java.util.Arrays;

public class WiggleSort2 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int bigger = n-1;
        int smaller = n/2;
        if(n%2 == 0) smaller--;
        int[] ans = new int[n];
        for(int i=0; i+1 < n; i+=2){
            ans[i] = nums[smaller--];
            ans[i+1] = nums[bigger--];
        }
        if(n%2 == 1) ans[n-1] = nums[0];
        System.arraycopy(ans, 0, nums, 0, n);
    }
}
