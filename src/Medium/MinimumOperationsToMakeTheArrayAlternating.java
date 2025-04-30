package Medium;

import java.util.HashMap;

public class MinimumOperationsToMakeTheArrayAlternating {
    public int minimumOperations(int[] nums) {
        int ans = 0;
        HashMap<Integer,Integer> hm1 = new HashMap<>();
        HashMap<Integer,Integer> hm2 = new HashMap<>();
        for(int i=0; i<nums.length; i+=2){
            int e = nums[i];
            hm1.put(e,hm1.getOrDefault(e,0)+1);
            if(i+1 == nums.length) break;
            int o = nums[i+1];
            hm2.put(o,hm2.getOrDefault(o,0)+1);
        }
        int max1 = 0;
        int max2 = 0;
        int idx1 = -1;
        int idx2 = -1;
        int dup1 = 0;
        for(int key:hm1.keySet()){
            int n = hm1.get(key);
            if(max1 == n) dup1++;
            if(max1 < n){
                dup1 = 1;
                max2 = max1;
                idx2 = idx1;
                max1 = n;
                idx1 = key;
            } else if(max2 < n){
                max2 = n;
                idx2 = key;
            }
        }
        int max3 = 0;
        int max4 = 0;
        int idx3 = -1;
        int idx4 = -1;
        int dup2 = 0;
        for(int key:hm2.keySet()){
            int n = hm2.get(key);
            if(max3 == n) dup2++;
            if(max3 < n){
                dup2 = 1;
                max4 = max3;
                idx4 = idx3;
                max3 = n;
                idx3 = key;
            } else if(max4 < n){
                max4 = n;
                idx4 = key;
            }
        }
        if(idx1 == idx3 && dup1 == 1 && dup2 == 1){
            return nums.length-Math.max(max1+max4,max2+max3);
        }
        return nums.length-max1-max3;
    }
}
