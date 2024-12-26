package Easy;

import java.util.Collections;
import java.util.PriorityQueue;

public class TakeGiftsFromTheRichestPile {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int n:gifts) pq.add(n);
        for(int i=0; i<k; i++){
            int n = pq.poll();
            pq.add((int)Math.sqrt(n));
        }
        long ans = 0;
        while(!pq.isEmpty()){
            ans += pq.poll();
        }
        return ans;
    }
}
