package Hard;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1) return nums;
        int[] ans = new int[nums.length-k+1];
        Deque<Integer> dq = new LinkedList<>();

        for(int i=0; i<k; i++){
            while(dq.size()>0 && nums[i] >= nums[dq.peekLast()]) dq.removeLast();
            dq.addLast(i);
        }

        for(int i=k; i<nums.length; i++){
            ans[i-k] = nums[dq.peek()];
            while(dq.size()>0 && dq.peek() <= i-k) dq.removeFirst();
            while(dq.size()>0 && nums[i] >= nums[dq.peekLast()]) dq.removeLast();
            dq.addLast(i);
        }
        ans[ans.length-1] = nums[dq.peek()];
        return ans;
    }
}
