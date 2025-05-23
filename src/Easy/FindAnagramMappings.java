package Easy;

import java.util.HashMap;

public class FindAnagramMappings {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<nums2.length; i++){
            hm.put(nums2[i],i);
        }
        int[] ans = new int[nums1.length];
        for(int i=0; i<ans.length; i++){
            ans[i] = hm.get(nums1[i]);
        }
        return ans;
    }
}
