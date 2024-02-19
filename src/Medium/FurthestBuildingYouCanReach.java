package Medium;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        int len = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<len-1; i++){
            int step = heights[i+1]-heights[i];
            if(step > 0){
                pq.offer(step);
                if(pq.size() > ladders){
                    bricks -= pq.poll();
                    if(bricks < 0) return i;
                }
            }
        }
        return len-1;
    }
}
