package Easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HighFive {
    public int[][] highFive(int[][] items) {
        HashMap<Integer, PriorityQueue<Integer>> hm = new HashMap<>();
        for(int[] it:items){
            if(hm.containsKey(it[0])) hm.get(it[0]).add(it[1]);
            else{
                PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                pq.add(it[1]);
                hm.put(it[0],pq);
            }
        }
        int[][] ans = new int[hm.size()][2];
        int j = 0;
        for(int key:hm.keySet()){
            int sum = 0;
            PriorityQueue<Integer> pq = hm.get(key);
            for(int i=0; i<5; i++) sum += pq.poll();
            ans[j++] = new int[]{key,sum/5};
        }
        Arrays.sort(ans, (a, b) -> a[0]-b[0]);
        return ans;
    }
}
