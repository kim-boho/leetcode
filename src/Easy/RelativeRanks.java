package Easy;

import java.util.Collections;
import java.util.TreeMap;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int l = score.length;
        String[] ans = new String[l];
        TreeMap<Integer, Integer> tm = new TreeMap<>(Collections.reverseOrder());
        for(int i=0; i<l; i++){
            tm.put(score[i],i);
        }
        int i = 0;
        String[] medals = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        while(i < 3 && !tm.isEmpty()){
            int k = tm.firstKey();
            ans[tm.remove(k)] = medals[i++];
        }
        i++;
        while(i <= l){
            int k = tm.firstKey();
            ans[tm.remove(k)] = String.valueOf(i++);
        }
        return ans;
    }
}
