package Medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindMinimumTimeToReachLastRoom2 {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] dp = new int[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0]-y[0]);
        for(int[] arr:dp) Arrays.fill(arr,Integer.MAX_VALUE);
        int[] arr = {0,0,0,1};
        pq.add(arr);
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int t = temp[0];
            int r = temp[1];
            int c = temp[2];
            int sec = temp[3];
            int sec2 = sec==1? 2:1;
            dp[r][c] = t;
            if(r==n-1 && c==m-1) break;
            if(r-1 >= 0){
                int val = Math.max(t+sec,moveTime[r-1][c]+sec);
                if(dp[r-1][c] > val){
                    dp[r-1][c] = val;
                    int[] temp2 = {val,r-1,c,sec2};
                    pq.add(temp2);
                }
            }
            if(r+1 < n){
                int val = Math.max(t+sec,moveTime[r+1][c]+sec);
                if(dp[r+1][c] > val) {
                    dp[r+1][c] = val;
                    int[] temp2 = {val,r+1,c,sec2};
                    pq.add(temp2);
                }
            }
            if(c-1 >= 0){
                int val = Math.max(t+sec,moveTime[r][c-1]+sec);
                if(dp[r][c-1] > val){
                    dp[r][c-1] = val;
                    int[] temp2 = {val,r,c-1,sec2};
                    pq.add(temp2);
                }
            }
            if(c+1 < m){
                int val = Math.max(t+sec,moveTime[r][c+1]+sec);
                if(dp[r][c+1] > val){
                    dp[r][c+1] = val;
                    int[] temp2 = {val,r,c+1,sec2};
                    pq.add(temp2);
                }
            }
        }
        return dp[n-1][m-1];
    }
}
