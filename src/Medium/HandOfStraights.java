package Medium;

import java.util.HashMap;
import java.util.TreeSet;

public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i:hand) hm.put(i, hm.getOrDefault(i,0)+1);
        TreeSet<Integer> ts = new TreeSet<>(hm.keySet());
        while(!ts.isEmpty()){
            int start = ts.first();
            for(int i=start; i<start+groupSize; i++){
                if(hm.containsKey(i)){
                    if(hm.get(i) == 1){
                        hm.remove(i);
                        ts.remove(i);
                    }
                    else hm.put(i, hm.get(i)-1);
                } else return false;
            }
        }
        return true;
    }
}
