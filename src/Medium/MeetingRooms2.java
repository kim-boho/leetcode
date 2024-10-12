package Medium;

import java.util.Arrays;

public class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<starts.length; i++){
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int s = 0;
        int e = 0;
        int curr = 0;
        int max = 0;
        while(s < intervals.length){
            if(starts[s] < ends[e]){
                curr++;
                s++;
            } else{
                curr--;
                e++;
            }
            max = Math.max(max,curr);
        }
        return max;
    }
}
