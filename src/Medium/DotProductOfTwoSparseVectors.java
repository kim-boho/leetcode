package Medium;

import java.util.HashMap;

public class DotProductOfTwoSparseVectors {
    HashMap<Integer,Integer> hm = new HashMap<>();
    DotProductOfTwoSparseVectors(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0) hm.put(i,nums[i]);
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(DotProductOfTwoSparseVectors vec) {
        HashMap<Integer,Integer> hm2 = vec.hm;
        int ans = 0;
        for(int k:hm.keySet()){
            if(hm2.containsKey(k)) ans += (hm.get(k)*hm2.get(k));
        }
        return ans;
    }
}
