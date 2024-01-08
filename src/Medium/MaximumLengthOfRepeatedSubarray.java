package Medium;

import java.util.ArrayList;
import java.util.HashMap;

public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        int ans = 0;
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap();

        for(int i=0; i<nums2.length; i++){
            int n = nums2[i];
            if(hm.containsKey(n)){
                hm.get(n).add(i);
            } else{
                ArrayList<Integer> temp = new ArrayList();
                temp.add(i);
                hm.put(n,temp);
            }
        }

        for(int i=0; i<nums1.length; i++){
            int n = nums1[i];
            if(hm.containsKey(n)){
                ArrayList<Integer> temp = hm.get(n);
                int newIdx = i;
                for(int j=0; j<temp.size(); j++){
                    int idx = temp.get(j);
                    if(nums2.length-idx <= ans) break;
                    else{
                        int tempLen = 0;
                        int tempI = i;
                        while(tempI < nums1.length && idx < nums2.length && nums1[tempI] == nums2[idx]){
                            tempI++;
                            idx++;
                            tempLen++;
                        }
                        if(tempLen > ans){
                            ans = tempLen;
                            newIdx = tempI;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
