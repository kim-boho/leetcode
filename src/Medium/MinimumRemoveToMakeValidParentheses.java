package Medium;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<arr.length; i++){
            char c = arr[i];
            if(c == '(' || c == ')'){
                if(!stack.isEmpty() && arr[stack.peek()] == '(' && c == ')'){
                    stack.pop();
                } else{
                    stack.add(i);
                }
            }
        }
        while(!stack.isEmpty()){
            arr[stack.pop()] = '0';
        }
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (c != '0') sb.append(c);
        }
        return sb.toString();
    }
}
