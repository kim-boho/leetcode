package Easy;

import java.util.Stack;

public class MinimumStringLengthAfterRemovingSubstrings {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();
        for(char c:s.toCharArray()){
            if(c == 'B'){
                if(!st.isEmpty() && st.peek() == 'A'){
                    st.pop();
                } else st.add(c);
            } else if(c == 'D'){
                if(!st.isEmpty() && st.peek() == 'C'){
                    st.pop();
                } else st.add(c);
            } else{
                st.add(c);
            }
        }
        return st.size();
    }
}
