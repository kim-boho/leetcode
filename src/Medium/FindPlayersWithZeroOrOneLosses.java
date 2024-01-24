package Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class FindPlayersWithZeroOrOneLosses {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList();
        TreeMap<Integer, int[]> hm = new TreeMap();
        for(int[] arr:matches){
            int w = arr[0];
            int l = arr[1];
            if(hm.containsKey(w)) hm.get(w)[0]++;
            else{
                int[] i = new int[2];
                i[0]++;
                hm.put(w,i);
            }
            hm.get(w)[1]++;
            if(hm.containsKey(l)) hm.get(l)[1]++;
            else{
                int[] i = new int[2];
                i[1]++;
                hm.put(l,i);
            }
        }
        List<Integer> winners = new ArrayList();
        List<Integer> oneLosers = new ArrayList();
        for(Integer i:hm.keySet()){
            int[] temp = (int[]) hm.get(i);
            int num = temp[1] - temp[0];
            if(num == 0) winners.add(i);
            else if(num == 1) oneLosers.add(i);
        }
        ans.add(winners);
        ans.add(oneLosers);
        return ans;
    }
}
