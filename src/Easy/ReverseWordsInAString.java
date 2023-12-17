package Easy;

import java.util.Stack;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        int i = 0;
        StringBuilder sb = new StringBuilder("");
        while(i < s.length()){
            if(s.charAt(i) == ' '){
                sb.append(" ");
                i++;
            }
            else{
                Stack<Character> st = new Stack();
                while(i < s.length() && s.charAt(i) != ' '){
                    st.add(s.charAt(i++));
                }
                while(st.size()>0){
                    sb.append(st.pop());
                }
            }
        }
        return sb.toString();
    }
}
