package Medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class MinimumScoreOfAPathBetweenTwoCities {
    public int minScore(int n, int[][] roads) {
        ArrayList<int[]>[] dist = new ArrayList[n+1];
        for(int[] r:roads){
            ArrayList<int[]> temp1 = dist[r[0]];
            if(temp1 == null){
                temp1 = new ArrayList<>();
                dist[r[0]] = temp1;
            }
            temp1.add(new int[] {r[1],r[2]});
            ArrayList<int[]> temp2 = dist[r[1]];
            if(temp2 == null){
                temp2 = new ArrayList<>();
                dist[r[1]] = temp2;
            }
            temp2.add(new int[] {r[0],r[2]});
        }
        boolean[] checked = new boolean[n+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        int ans = Integer.MAX_VALUE;
        while(q.size() > 0){
            int num = q.poll();
            if(checked[num]) continue;
            checked[num] = true;
            ArrayList<int[]> di = dist[num];
            if(di == null) continue;
            for(int i=0; i<di.size(); i++){
                ans = Math.min(ans,di.get(i)[1]);
                q.add(di.get(i)[0]);
            }
        }
        return ans;
    }
}
