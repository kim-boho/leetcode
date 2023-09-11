package Hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        // time limit exceed
        char[] arr = s.toCharArray();
        boolean[] check = new boolean[arr.length];
        int left = 0;
        int right = 0;
        int total = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == '('){
                total++;
                left++;
            } else if(arr[i] == ')'){
                total++;
                right++;
            }
        }
        if(left == right){
            left = 0;
            right = 0;
        } else if(left > right){
            left -= right;
            right = 0;
        } else {
            right -= left;
            left = 0;
        }

        HashSet<String> hs = new HashSet();
        while(left+right<=total && hs.size() == 0){
            removeParenthese(left, right, arr, check, hs);
            left++;
            right++;
        }

        List<String> ans = new ArrayList(hs);
        return ans;
    }

    private void removeParenthese(int left, int right, char[] arr, boolean[] check, HashSet<String> hs){
        if(left+right == 0){
            if(validate(arr)){
                StringBuilder sb = new StringBuilder("");
                for(char c:arr){
                    if(c != '*') sb.append(c);
                }
                hs.add(sb.toString());
            }
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(!check[i] && arr[i] == '(' || arr[i] == ')'){
                check[i] = true;
                if(left>0 && arr[i] == '('){
                    arr[i] = '*';
                    removeParenthese(left-1, right, arr, check, hs);
                    arr[i] = '(';
                } else if(right>0 && arr[i] == ')'){
                    arr[i] = '*';
                    removeParenthese(left, right-1, arr, check, hs);
                    arr[i] = ')';
                }
                check[i] = false;
            }
        }
    }

    private boolean validate(char[] arr){
        Stack<Character> st = new Stack();
        for(int i=0; i<arr.length; i++){
            if(arr[i] == '('){
                st.add('(');
            } else if(arr[i] == ')'){
                if(st.size() == 0) return false;
                else{
                    st.pop();
                }
            }
        }
        if(st.size() > 0) return false;
        else return true;
    }
}
