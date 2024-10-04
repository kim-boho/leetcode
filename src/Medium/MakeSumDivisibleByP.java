package Medium;

import java.util.HashMap;

public class MakeSumDivisibleByP {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        if(sum < p) return -1;
        long rem = sum % p;
        if(rem == 0) return 0;

        int ans = nums.length;
        long subSum = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,-1);
        for(int i=0; i<nums.length; i++){
            subSum += nums[i];
            int prefixRem = (int)(subSum % p);
            int neededRem = (int)(prefixRem-rem+p) % p;
            if(hm.containsKey(neededRem)){
                ans = Math.min(ans, i-hm.get(neededRem));
            }
            hm.put(prefixRem, i);
        }
        return ans == nums.length? -1:ans;
    }
}
