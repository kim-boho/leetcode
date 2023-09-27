package Easy;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    class MyStack {
        Queue<Integer> q;
        public MyStack() {
            q = new LinkedList();
        }

        public void push(int x) {
            Queue<Integer> temp = new LinkedList();
            temp.add(x);
            while(q.size() > 0) temp.add(q.poll());
            q = temp;
        }

        public int pop() {
            return q.poll();
        }

        public int top() {
            return q.peek();
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }
}
