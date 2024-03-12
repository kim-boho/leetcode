package Easy;

import java.util.Stack;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack();
        Stack<Character> st2 = new Stack();
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        for(char c:arr1){
            if(c == '#' && !st.isEmpty()) st.pop();
            else if(c != '#') st.add(c);
        }
        for(char c:arr2){
            if(c == '#' && !st2.isEmpty()) st2.pop();
            else if(c != '#') st2.add(c);
        }
        if(st.size() != st2.size()) return false;
        else{
            int count = st.size();
            while(count-- > 0){
                if(st.pop() != st2.pop()) return false;
            }
            return true;
        }
    }
}
