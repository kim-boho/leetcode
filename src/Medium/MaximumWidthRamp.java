package Medium;

public class MaximumWidthRamp {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int[] rightMax = new int[n];
        rightMax[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--) rightMax[i] = Math.max(rightMax[i+1],nums[i]);
        int i=0, j=1;
        int ans = 0;
        while(j < n){
            while(i < j && nums[i] > rightMax[j]) i++;
            ans = Math.max(ans, j-i);
            j++;
        }
        return ans;
    }
}
