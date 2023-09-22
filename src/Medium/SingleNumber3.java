package Medium;

import java.util.HashSet;
import java.util.Iterator;

public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> hs = new HashSet();
        for(int i:nums){
            if(hs.contains(i)) hs.remove(i);
            else hs.add(i);
        }
        Iterator it = hs.iterator();
        int[] ans = new int[hs.size()];
        int idx = 0;
        while(it.hasNext()){
            int i = (int) it.next();
            ans[idx++] = i;
        }
        return ans;
    }
}
