package Easy;

import java.util.Stack;

public class ImplementQueueUsingStacks {

}

class MyQueue{
    Stack<Integer> st;
    Stack<Integer> helper;
    public MyQueue() {
        st = new Stack();
        helper = new Stack();
    }

    public void push(int x) {
        while(st.size() > 0){
            helper.push(st.pop());
        };
        helper.push(x);
        while(helper.size() > 0){
            st.push(helper.pop());
        }
    }

    public int pop() {
        return st.pop();
    }

    public int peek() {
        return st.peek();
    }

    public boolean empty() {
        return st.empty();
    }
}