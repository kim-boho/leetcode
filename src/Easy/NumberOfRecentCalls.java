package Easy;

import java.util.PriorityQueue;

public class NumberOfRecentCalls {
    PriorityQueue<Integer> pq;
    public NumberOfRecentCalls() {
        pq = new PriorityQueue<>();
    }

    public int ping(int t) {
        pq.add(t);
        while(!pq.isEmpty() && pq.peek() < t-3000) pq.remove();
        return pq.size();
    }
}
