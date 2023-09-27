package Medium;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] arr = new int[26];
        for(int i=0; i<s.length(); i++) arr[s.charAt(i)-'a']++;

        boolean[] checked = new boolean[26];
        Stack<Character> st = new Stack();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(arr[c-'a'] > 0 && !checked[c-'a']){
                if(st.size() == 0){
                    st.add(c);
                    checked[c-'a'] = true;
                } else{
                    char top = st.peek();
                    if(top < c){
                        if(!checked[c-'a']){
                            checked[c-'a'] = true;
                            st.add(c);
                        }
                    } else if(top == c){
                        arr[c-'a']--;
                        continue;
                    } else {
                        while(top > c){
                            if(arr[top-'a'] == 0) break;
                            else if(arr[top-'a'] > 0){
                                checked[st.pop()-'a'] = false;
                            }
                            if(st.size()==0) break;
                            top = st.peek();
                        }
                        if(!checked[c-'a']){
                            st.add(c);
                            checked[c-'a'] = true;
                        }
                    }
                }
            }
            arr[c-'a']--;
        }

        StringBuilder sb = new StringBuilder("");
        while(st.size() > 0){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}
