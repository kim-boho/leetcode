package Easy;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap();
        ArrayList<Integer> li = new ArrayList();

        for(int i=0; i<nums2.length; i++){
            if(hm.containsKey(nums2[i])){
                hm.put(nums2[i], hm.get(nums2[i])+1);
            } else{
                hm.put(nums2[i],1);
            }
        }

        for(int i=0; i<nums1.length; i++){
            if(hm.containsKey(nums1[i])){
                if(hm.get(nums1[i])>0){
                    hm.put(nums1[i], hm.get(nums1[i])-1);
                    li.add(nums1[i]);
                }
            }
        }

        int[] ans = new int[li.size()];
        for(int i=0; i<ans.length; i++){
            ans[i] = li.get(i);
        }

        return ans;


    }
}
