package Medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class RandomPickIndex {
    HashMap<Integer, Queue> hm = new HashMap();
    class Solution{
        public Solution(int[] nums) {
            for(int i=0; i<nums.length; i++){
                int n = nums[i];
                if(hm.containsKey(n)){
                    hm.get(n).add(i);
                } else{
                    Queue<Integer> q = new LinkedList();
                    q.add(i);
                    hm.put(n,q);
                }
            }
        }

        public int pick(int target) {
            int ans = (int)hm.get(target).poll();
            hm.get(target).add(ans);
            return ans;
        }
    }
}
