package Medium;

import java.util.PriorityQueue;

public class MinimumOperationsToExceedThresholdValue2 {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new  PriorityQueue<>();
        for(int n:nums) pq.add((long)n);
        int ans = 0;
        while(pq.size() > 1 && pq.peek() < k){
            long n1 = pq.poll();
            long n2 = pq.poll();
            pq.add(Math.min(n1,n2)*2+Math.max(n1,n2));
            ans++;
        }
        return ans;
    }
}
