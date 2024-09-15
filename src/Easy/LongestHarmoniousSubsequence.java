package Easy;

import java.util.HashMap;

public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int ans = 0;
        for(int n:nums) hm.put(n,hm.getOrDefault(n,0)+1);
        for(int k:hm.keySet()){
            int curr = hm.get(k);
            if(hm.containsKey(k-1)){
                ans = Math.max(curr+hm.get(k-1),ans);
            }
            if(hm.containsKey(k+1)){
                ans = Math.max(curr+hm.get(k+1),ans);
            }
        }
        return ans;
    }
}
