package Medium;

import java.util.ArrayList;

public class MinStack {
    ArrayList<Integer> st = null;
    ArrayList<Integer> minSt = null;
    public MinStack() {
        st = new ArrayList<>();
        minSt = new ArrayList<>();
    }

    public void push(int val) {
        if(st.size() == 0) minSt.add(val);
        else{
            if(minSt.get(minSt.size()-1) < val) minSt.add(minSt.get(minSt.size()-1));
            else minSt.add(val);
        }
        st.add(val);
    }

    public void pop() {
        if(st.size() == 0) return;
        st.remove(st.size()-1);
        minSt.remove(minSt.size()-1);
    }

    public int top() {
        if(st.size() == 0) return (Integer) null;
        else return st.get(st.size()-1);
    }

    public int getMin() {
        if(minSt.size() == 0) return (Integer) null;
        else return minSt.get(minSt.size()-1);
    }
}
