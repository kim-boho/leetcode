package Medium;

import java.util.Stack;

public class UsingARobotToPrintTheLexicographicallySmallestString {
    public String robotWithString(String s) {
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        for(char c:chars) count[c-'a']++;
        Stack<Character> t = new Stack();
        StringBuilder p = new StringBuilder();
        int j = 0;
        while(count[j] == 0) j++;
        for(int i=0; i<chars.length; i++){
            while(!t.isEmpty() && t.peek() <= (char)(j+'a')) p.append(t.pop());
            if(chars[i] == (char)(j+'a')){
                p.append(chars[i]);
            } else{
                while(!t.isEmpty() && t.peek() == (char)(j+'a')) p.append(t.pop());
                t.add(chars[i]);
            }
            count[chars[i]-'a']--;
            while(j<count.length && count[j] == 0) j++;
            if(j == count.length){
                i++;
                for(;i<chars.length; i++){
                    while(!t.isEmpty() && t.peek() <= chars[i]) p.append(t.pop());
                    t.add(chars[i]);
                }
            }
        }
        while(!t.isEmpty()) p.append(t.pop());
        return p.toString();
    }
}
