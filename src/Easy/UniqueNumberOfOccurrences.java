package Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap();
        for(int i:arr){
            if(hm.containsKey(i)) hm.put(i,hm.get(i)+1);
            else hm.put(i,1);
        }

        Iterator<Integer> it = hm.keySet().iterator();
        HashSet<Integer> hs = new HashSet();
        while(it.hasNext()){
            int n = (int) it.next();
            if(hs.contains(hm.get(n))) return false;
            else hs.add(hm.get(n));
        }
        return true;
    }
}
