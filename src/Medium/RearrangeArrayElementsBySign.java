package Medium;

public class RearrangeArrayElementsBySign {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int p = 0;
        int m = 1;
        for (int num : nums) {
            if (num > 0) {
                ans[p] = num;
                p += 2;
            } else {
                ans[m] = num;
                m += 2;
            }
        }
        return ans;
    }
}
