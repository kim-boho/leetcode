package Easy;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        HashMap<Integer, Integer> hm = new HashMap();
        hm.put(nums2[nums2.length-1], -1);
        Stack<Integer> st = new Stack();
        st.add(nums2[nums2.length-1]);
        for(int i=nums2.length-2; i>=0; i--){
            int n = nums2[i];
            while(st.size()>0 && st.peek()<=n){
                st.pop();
            }
            if(st.size()==0) hm.put(n, -1);
            else hm.put(n,st.peek());
            st.add(n);
        }
        for(int i=0; i<ans.length; i++){
            ans[i] = hm.get(nums1[i]);
        }
        return ans;
    }
}
