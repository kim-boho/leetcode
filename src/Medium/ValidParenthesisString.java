package Medium;

import java.util.Stack;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        char[] arr = s.toCharArray();
        Stack<Integer> wildcards = new Stack<>();
        Stack<Integer> lefts = new Stack<>();
        for(int i=0; i<arr.length; i++){
            if(arr[i] == '*') wildcards.add(i);
            else if(arr[i] == '(') lefts.add(i);
            else{
                if(lefts.isEmpty()){
                    if(wildcards.isEmpty()) return false;
                    else wildcards.pop();
                } else lefts.pop();
            }
        }
        if (!lefts.isEmpty()) {
            while (!lefts.isEmpty()) {
                if (wildcards.isEmpty()) return false;
                else {
                    if (wildcards.pop() < lefts.pop()) return false;
                }
            }
        }
        return true;
    }
}
