package Easy;

import java.util.HashMap;
import java.util.HashSet;

public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        int dgr = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        HashMap<Integer, Integer> start = new HashMap<>();
        HashMap<Integer, Integer> end = new HashMap<>();
        HashSet<Integer> maxs = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            if(start.containsKey(n)){
                end.put(n,i);
            } else start.put(n,i);
            int temp = hm.getOrDefault(n,0);
            hm.put(n,temp+1);
            if(dgr < temp+1){
                dgr = temp+1;
                maxs = new HashSet<>();
                maxs.add(n);
            } else if(dgr == temp+1){
                maxs.add(n);
            }
        }
        if(dgr == 1) return 1;
        int ans = nums.length;
        for(int n:maxs){
            int len = end.get(n)-start.get(n)+1;
            if(ans > len) ans = len;
        }
        return ans;
    }
}
