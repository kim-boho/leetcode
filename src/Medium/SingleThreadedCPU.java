package Medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SingleThreadedCPU {
    public int[] getOrder(int[][] tasks) {
        int[][] tasks2 = new int[tasks.length][3];
        for(int i=0; i<tasks.length; i++){
            tasks2[i] = new int[]{tasks[i][0],tasks[i][1],i};
        }
        Arrays.sort(tasks2,(a, b) -> a[0]-b[0]);
        int end = tasks2[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[1] == b[1]) return Integer.compare(a[2], b[2]);
            return Integer.compare(a[1], b[1]);  // Compare by the second element
        });
        int i = 0;
        int[] ans = new int[tasks2.length];
        int p = 0;
        while(i<tasks2.length){
            while(i<tasks2.length && tasks2[i][0] <= end){
                pq.add(tasks2[i++]);
            }
            if(pq.isEmpty()){
                int nextStart = tasks2[i][0];
                while(i<tasks2.length && tasks2[i][0] == nextStart){
                    pq.add(tasks2[i++]);
                }
                end = nextStart;
            }
            int[] nextTask = pq.poll();
            ans[p++] = nextTask[2];
            end += nextTask[1];
        }
        while(!pq.isEmpty()){
            ans[p++] = pq.poll()[2];
        }
        return ans;
    }
}
