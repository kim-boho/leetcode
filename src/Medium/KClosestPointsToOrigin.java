package Medium;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0]*a[0]+a[1]*a[1]) - (b[0]*b[0]+b[1]*b[1]));
        for(int[] p:points){
            pq.offer(p);
        }
        for(int i=0; i<ans.length; i++){
            ans[i] = pq.poll();
        }
        return ans;
    }
}
