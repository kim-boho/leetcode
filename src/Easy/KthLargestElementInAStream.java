package Easy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    PriorityQueue<Integer> q;
    int k;
    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>();
        Arrays.sort(nums);
        for(int i=Math.max(0,nums.length-k); i<nums.length; i++) q.add(nums[i]);
    }

    public int add(int val) {
        q.add(val);
        if(q.size()>k) q.poll();
        return q.peek();
    }
}
