package Medium;

import java.util.HashMap;
import java.util.Iterator;

public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num:nums){
            if(hm.containsKey(num)) hm.put(num, hm.get(num)+1);
            else hm.put(num,1);
        }

        Iterator it = hm.keySet().iterator();
        while(it.hasNext()){
            int n = (int)it.next();
            if(hm.get(n) == 1) return n;
        }
        return -1;
    }
}
