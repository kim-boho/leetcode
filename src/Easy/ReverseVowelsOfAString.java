package Easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        char[] charArr = s.toCharArray();
        int start = 0;
        int end = charArr.length-1;
        HashSet<Character> hs = new HashSet();
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');
        hs.add('A');
        hs.add('E');
        hs.add('I');
        hs.add('O');
        hs.add('U');
        while(start<end){
            while(!hs.contains(charArr[start]) && start<end) start++;
            while(!hs.contains(charArr[end]) && end>start) end--;
            if(start < end && charArr[start] != charArr[end]){
                char temp = charArr[start];
                charArr[start] = charArr[end];
                charArr[end] = temp;
            }
            start++;
            end--;
        }
        return new String(charArr);
    }
}
