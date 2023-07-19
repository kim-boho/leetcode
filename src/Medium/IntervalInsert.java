package Medium;

import java.util.ArrayList;
import java.util.List;

public class IntervalInsert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        int l = newInterval[0];
        int r = newInterval[1];
        List<Integer> li = new ArrayList<>();
        int idx = 0;
        while(idx<len && intervals[idx][1]<l){
            li.add(intervals[idx][0]);
            li.add(intervals[idx++][1]);
        }
        if(idx == len){
            li.add(l);
            li.add(r);
        } else{
            if(intervals[idx][0]<=l) li.add(intervals[idx][0]);
            else li.add(l);
            while(idx<len && intervals[idx][1] < r) idx++;
            if(idx==len){
                li.add(r);
            } else{
                if(intervals[idx][0] <= r) li.add(intervals[idx++][1]);
                else li.add(r);
                while(idx<len){
                    li.add(intervals[idx][0]);
                    li.add(intervals[idx++][1]);
                }
            }
        }
        int[][] ans = new int[li.size()/2][2];
        for(int i=0; i<ans.length; i++){
            ans[i][0] = li.get(i*2);
            ans[i][1] = li.get(i*2+1);
        }

        return ans;
    }
}
