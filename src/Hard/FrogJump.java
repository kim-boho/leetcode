package Hard;

import java.util.HashSet;
import java.util.TreeMap;

public class FrogJump {
    public boolean canCross(int[] stones) {
        int len = stones.length;
        if(len<2) return true;

        TreeMap<Integer, HashSet<Integer>> hm = new TreeMap<Integer, HashSet<Integer>>();
        for(int n:stones) hm.put(n,new HashSet<Integer>());
        hm.get(stones[0]).add(1);
        for (Integer integer : hm.keySet()) {
            int key = (int) integer;
            HashSet<Integer> hs = hm.get(key);
            for (Integer h : hs) {
                int step = (int) h;
                if (hm.containsKey(key + step)) {
                    hm.get(key + step).add(step);
                    hm.get(key + step).add(step + 1);
                    if (step != 1) hm.get(key + step).add(step - 1);
                }
            }
        }
        return !hm.get(stones[len-1]).isEmpty();
    }
}
