package Medium;

import java.util.HashMap;

public class CountNicePairsInAnArray {
    public int countNicePairs(int[] nums) {
        long[] revs = new long[nums.length];
        HashMap<Long, Integer> diffs = diffsSet(nums,revs);
        long ans = 0;
        for(int i=0; i<nums.length; i++){
            long diff = nums[i]-revs[i];
            ans += (diffs.get(diff)-1);
            ans %= 1000000007;
            diffs.put(diff,diffs.get(diff)-1);
        }
        return (int)ans;
    }

    private HashMap<Long, Integer> diffsSet(int[] nums, long[] revs){
        HashMap<Long, Integer> ans = new HashMap();
        for(int i=0; i<nums.length; i++){
            int temp = nums[i];
            long rev = 0;
            while(temp > 0){
                rev += (long)(temp%10);
                temp /= 10;
                rev *= 10;
            }
            rev /= 10;
            revs[i] = rev;
            long diff = (long)nums[i]-rev;
            ans.put(diff, ans.getOrDefault(diff,0)+1);
        }
        return ans;
    }
}
