package Hard;

import java.util.Arrays;
import java.util.PriorityQueue;

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] proAndCap = new int[n][2];
        for(int i=0; i<n; i++){
            proAndCap[i][0] = profits[i];
            proAndCap[i][1] = capital[i];
        }
        Arrays.sort(proAndCap, (a, b) -> a[1]-b[1]);
        int p = 0;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            return b[0]-a[0];
        });
        for(int i=0; i<k; i++){
            while(p < n && proAndCap[p][1] <= w){
                maxHeap.add(proAndCap[p]);
                p++;
            }
            if(!maxHeap.isEmpty()){
                w += maxHeap.poll()[0];
            } else break;
        }
        return w;
    }
}
