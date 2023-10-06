package Medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class FindKPairsWithSmallestSums {    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    // time limit exceeded
    List<List<Integer>> ans = new ArrayList();
    if(k==0) return ans;
    TreeMap<Integer, List<List<Integer>>> hm = new TreeMap();
    for(int i=0; i<nums1.length; i++){
        for(int j=0; j<nums2.length; j++){
            List<Integer> temp = new ArrayList();
            temp.add(nums1[i]);
            temp.add(nums2[j]);
            int sum = nums1[i]+nums2[j];
            if(hm.containsKey(sum)){
                hm.get(sum).add(temp);
            } else{
                List<List<Integer>> temp2 = new ArrayList();
                temp2.add(temp);
                hm.put(sum, temp2);
            }
        }
    }

    int count = 0;
    Iterator it = hm.keySet().iterator();
    while(it.hasNext()){
        List<List<Integer>> li = hm.get((int)it.next());
        for(int i=0; i<li.size(); i++){
            ans.add(li.get(i));
            if(++count == k) return ans;
        }
    }
    return ans;
}
}
