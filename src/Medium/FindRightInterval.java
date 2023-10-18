package Medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        HashMap<Integer, Integer> hm = new HashMap();
        int[] sortedStart = new int[len];
        for(int i=0; i<len; i++){
            hm.put(intervals[i][0],i);
            sortedStart[i] = intervals[i][0];
        }

        Arrays.sort(sortedStart);
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2) {
                if(i1[1] > i2[1]) return 1;
                else if (i1[1] < i2[1]) return -1;
                else return 0;
            }
        });

        int[] ans = new int[len];
        Arrays.fill(ans, -1);
        int idx = 0;
        for(int i=0; i<len; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            while(idx < len && sortedStart[idx] < end) idx++;
            if(idx != len) ans[hm.get(start)] = hm.get(sortedStart[idx]);
            else break;
        }

        return ans;
    }
}
