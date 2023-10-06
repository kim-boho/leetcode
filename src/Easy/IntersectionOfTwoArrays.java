package Easy;

import java.util.HashSet;
import java.util.Iterator;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet();
        for(int i:nums1){
            hs.add(i);
        }

        HashSet<Integer> hs2 = new HashSet();
        for(int i:nums2){
            if(hs.contains(i)) hs2.add(i);
        }

        Iterator it = hs2.iterator();
        int[] ans = new int[hs2.size()];
        int count = 0;
        while(it.hasNext()){
            ans[count++] = (int) it.next();
        }
        return ans;
    }
}
