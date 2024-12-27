package Easy;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++){
            char c = arr[i];
            if(st.isEmpty() || st.peek() != c) st.add(c);
            else st.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());
        return sb.reverse().toString();
    }
}
