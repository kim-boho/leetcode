package Medium;

public class RotateFunction {
    public int maxRotateFunction(int[] nums) {
        if(nums.length == 1) return 0;
        int sum = 0;
        int prev = 0;
        int len = nums.length;
        for(int i=0; i<len; i++){
            sum += nums[i];
            prev += i*nums[i];
        }

        int ans = prev;
        for(int i=1; i<len; i++){
            int tempSum = prev + sum - len*nums[len-i];
            if(tempSum > ans) ans = tempSum;
            prev = tempSum;
        }
        return ans;
    }
}
