package Medium;

import java.util.HashMap;
import java.util.HashSet;

public class FindingTheUsersActiveMinutes {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer, HashSet<Integer>> uniqs = new HashMap<>();
        int[] ans = new int[k];
        for(int[] l:logs){
            if(!uniqs.containsKey(l[0])) uniqs.put(l[0],new HashSet<>());
            uniqs.get(l[0]).add(l[1]);
        }
        for(int key:uniqs.keySet()){
            ans[uniqs.get(key).size()-1]++;
        }
        return ans;
    }
}
