package Hard;

import java.util.ArrayList;
import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int index = 0;
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> valids = new ArrayList<>();
        int max = 0;

        while(index < s.length()){
            char ch = s.charAt(index);
            if(ch == '('){
                st.push(index);
            } else if(ch == ')' && st.size() > 0){
                int start = st.pop();
                int end = index;
                if(valids.size() == 0){
                    valids.add(start);
                    valids.add(end);
                } else{
                    int prevStart = valids.get(valids.size() - 2);
                    int prevEnd = valids.get(valids.size() - 1);
                    int i= valids.size()-1;
                    if(prevStart > start && prevEnd < end){
                        valids.set(valids.size() - 2, start);
                        valids.set(valids.size() - 1, end);
                        if(valids.size() > 3 && valids.get(valids.size()-3)+1 == valids.get(valids.size()-2)){
                            valids.set(valids.size() - 3, valids.get(valids.size()-1));
                            valids.remove(valids.size() - 1);
                            valids.remove(valids.size() - 1);
                        }
                    } else if(prevEnd + 1 == start){
                        valids.set(valids.size() - 1, end);
                    } else{
                        valids.add(start);
                        valids.add(end);
                    }
                }
                max = Math.max(max, valids.get(valids.size()-1)-valids.get(valids.size()-2)+1);
            }
            index++;
        }

        return max;
    }
}
