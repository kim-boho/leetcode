package Easy;

import java.util.HashSet;

public class FairCandySwap {
    public int[] fairCandySwap(int[] alice, int[] bob) {
        int a = 0;
        int b = 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int i:alice) a+=i;
        for(int i:bob){
            b+=i;
            hs.add(i);
        }
        for(int i:alice){
            if(hs.contains((b-a)/2+i)) return new int[]{i,(b-a)/2+i};
        }
        return null;
    }
}
