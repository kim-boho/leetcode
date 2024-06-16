package Medium;

import java.util.HashMap;

public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        int ans = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int n:nums){
            prefixSum += n;
            int rem = prefixSum%k;
            if(rem < 0) rem += k;
            if(hm.containsKey(rem)){
                ans += hm.get(rem);
                hm.put(rem,hm.get(rem)+1);
            } else hm.put(rem,1);
        }
        return ans;
    }
}
