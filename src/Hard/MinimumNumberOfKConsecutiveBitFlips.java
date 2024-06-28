package Hard;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumNumberOfKConsecutiveBitFlips {
    public int minKBitFlips(int[] nums, int k) {
        Queue<Integer> q = new LinkedList<>();
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            while(q.size() > 0 && q.peek() <= i-k) q.poll();
            int r = q.size()%2^nums[i];
            if(r == 0){
                if(i+k>nums.length) return -1;
                q.add(i);
                ans++;
            }
        }
        return ans;
    }
}
