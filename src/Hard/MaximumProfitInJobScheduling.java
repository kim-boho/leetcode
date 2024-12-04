package Hard;

import java.util.Arrays;
import java.util.TreeMap;

public class MaximumProfitInJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] times = new int[n][3];
        for(int i=0; i<n; i++){
            times[i][0] = startTime[i];
            times[i][1] = endTime[i];
            times[i][2] = profit[i];
        }
        Arrays.sort(times, (a, b) -> a[1]-b[1]);
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        tm.put(0,0);
        int ans = 0;
        for(int i=0; i<n; i++){
            int max = tm.get(tm.floorKey(times[i][0]));
            ans = Math.max(ans,max+times[i][2]);
            tm.put(times[i][1],Math.max(tm.getOrDefault(times[i][1],0),ans));
        }
        return ans;
    }
}
