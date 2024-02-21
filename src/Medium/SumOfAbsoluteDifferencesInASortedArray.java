package Medium;

public class SumOfAbsoluteDifferencesInASortedArray {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int sum = 0;
        for(int n:nums) sum += (n-nums[0]);
        ans[0] = sum;
        for(int i=1; i<len; i++){
            int gap = nums[i]-nums[i-1];
            ans[i] = sum+(i-1)*gap-(len-1-i)*gap;
            sum = ans[i];
        }
        return ans;
    }
}
