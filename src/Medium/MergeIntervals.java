package Medium;

import java.util.Arrays;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a, b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            else return a[1]-b[1];
        });
        int maxEnd = intervals[0][1];
        int idx = 0;
        int count = 0;
        for(int i=1; i<intervals.length; i++){
            if(maxEnd >= intervals[i][0]){
                intervals[idx][1] = Math.max(maxEnd, intervals[i][1]);
                intervals[i][0] = -1;
                maxEnd = intervals[idx][1];
                count++;
            } else {
                maxEnd = intervals[i][1];
                idx = i;
            }
        }
        int[][] ans = new int[intervals.length-count][2];
        int ansIdx = 0;
        for(int i=0; i<intervals.length; i++){
            if(intervals[i][0] != -1) ans[ansIdx++] = intervals[i];
        }
        return ans;
    }
}
