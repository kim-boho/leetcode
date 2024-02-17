package Medium;

import java.util.HashMap;
import java.util.TreeMap;

public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> occ = new HashMap();
        for(int n:arr) occ.put(n,occ.getOrDefault(n,0)+1);

        TreeMap<Integer, Integer> occNums = new TreeMap();
        for(Integer key:occ.keySet()){
            occNums.put(occ.get(key),occNums.getOrDefault(occ.get(key),0)+1);
        }

        int total = occ.size();
        for(Integer key:occNums.keySet()){
            int temp = key*occNums.get(key);
            if(k > temp){
                k -= temp;
                total -= occNums.get(key);
            } else{
                while(k >= key){
                    total--;
                    k -= key;
                }
                break;
            }
        }
        return total;
    }
}
