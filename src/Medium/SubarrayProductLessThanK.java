package Medium;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k==0) return 0;
        int ans = 0;
        int num = 1;
        int j = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] >= k) continue;
            if(i >= j){
                j = i+1;
                num *= nums[i];
            }
            for(; j<nums.length && num < k; j++) num *= nums[j];
            if(num < k){
                ans += (j-i)*(j-i+1)/2;
                return ans;
            } else{
                num /= nums[--j];
                ans += j-i;
                num /= nums[i];
            }
        }
        return ans;
    }
}
