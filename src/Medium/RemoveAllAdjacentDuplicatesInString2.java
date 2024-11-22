package Medium;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString2 {
    public String removeDuplicates(String s, int k) {
        Stack<char[]> st = new Stack<>();
        for(char c:s.toCharArray()){
            if(st.isEmpty()){
                char[] temp = {c,'1'};
                st.add(temp);
            } else{
                char[] cArr = st.peek();
                if(cArr[0] == c){
                    if(cArr[1] == (char)('0'+(k-1))) {
                        st.pop();
                    } else{
                        cArr[1]++;
                    }
                } else{
                    char[] temp ={c,'1'};
                    st.add(temp);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            char[] cArr = st.pop();
            for(char c='0'; c<cArr[1]; c++){
                sb.append(cArr[0]);
            }
        }
        return sb.reverse().toString();
    }
}
