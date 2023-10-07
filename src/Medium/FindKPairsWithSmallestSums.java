package Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList();
        if(k==0) return ans;

        TreeMap<Integer, List<List<Integer>>> tm = new TreeMap();
        int[] idx = new int[nums1.length];

        for(int i=0; i<nums1.length; i++){
            idx[i]++;
            List<Integer> temp = new ArrayList();
            temp.add(i);
            temp.add(0);
            int sum = nums1[i]+nums2[0];
            if(tm.containsKey(sum)){
                tm.get(sum).add(temp);
            } else{
                List<List<Integer>> li = new ArrayList();
                li.add(temp);
                tm.put(sum, li);
            }
        }

        while(tm.size() > 0){
            int sum = (int) tm.firstKey();
            List<List<Integer>> li = tm.get(sum);
            tm.remove(sum);
            int count = li.size();

            for(int i=0; i<count; i++){
                int idx1 = li.get(i).get(0);
                int idx2 = li.get(i).get(1);
                List<Integer> temp = new ArrayList();
                temp.add(nums1[idx1]);
                temp.add(nums2[idx2]);
                ans.add(temp);

                if(ans.size() == k) return ans;

                if(idx2 < nums2.length-1){
                    List<Integer> tempLi = new ArrayList();
                    tempLi.add(idx1);
                    tempLi.add(idx2+1);
                    int nextSum = nums1[idx1]+nums2[idx2+1];

                    if(tm.containsKey(nextSum)){
                        tm.get(nextSum).add(tempLi);
                    } else{
                        List<List<Integer>> li2 = new ArrayList();
                        li2.add(tempLi);
                        tm.put(nextSum, li2);
                    }
                }
            }
        }
        return ans;
    }
}
