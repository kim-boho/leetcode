package Medium;

import java.util.Arrays;

public class FindClosestNodeToGivenTwoNodes {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] checked = new int[edges.length];
        Arrays.fill(checked,-1);
        int next = node1;
        int dist = 0;
        while(next != -1 && checked[next] == -1){
            checked[next] = dist++;
            next = edges[next];
        }
        int[] checked2 = new int[edges.length];
        Arrays.fill(checked2,-1);
        next = node2;
        dist = 0;
        while(next != -1 && checked2[next] == -1){
            checked2[next] = dist++;
            next = edges[next];
        }
        int ans = edges.length;
        int idx = -1;
        for(int i=0; i<checked.length; i++){
            if(checked[i] != -1 && checked2[i] != -1 && ans > Math.max(checked[i],checked2[i])){
                ans = Math.min(ans,Math.max(checked[i],checked2[i]));
                idx = i;
            }
        }
        return idx;
    }
}
