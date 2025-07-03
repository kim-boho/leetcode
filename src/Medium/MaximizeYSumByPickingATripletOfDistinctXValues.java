package Medium;

import java.util.Arrays;
import java.util.HashMap;

public class MaximizeYSumByPickingATripletOfDistinctXValues {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<x.length; i++){
            int n = x[i];
            hm.put(n,Math.max(hm.getOrDefault(n,y[i]),y[i]));
        }
        if(hm.size() < 3) return -1;
        int ans = 0;
        int[] sorted = new int[hm.size()];
        int i = 0;
        for(int key:hm.keySet()){
            sorted[i++] = hm.get(key);
        }
        Arrays.sort(sorted);
        return sorted[sorted.length-1]+sorted[sorted.length-2]+sorted[sorted.length-3];
    }
}
