package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<s1.length(); i++){
            if(hm.containsKey(s1.charAt(i))) hm.put(s1.charAt(i), hm.get(s1.charAt(i))+1);
            else hm.put(s1.charAt(i), 1);
        }

        int count = s1.length();
        for(int i=0; i<s1.length(); i++){
            if(hm.containsKey(s2.charAt(i))){
                if(hm.get(s2.charAt(i))>0) count--;
                hm.put(s2.charAt(i), hm.get(s2.charAt(i))-1);
            }
        }
        if(count == 0) return true;

        int start = 0;
        int end = s1.length();
        while(end < s2.length()){
            if(hm.containsKey(s2.charAt(start))){
                if(hm.get(s2.charAt(start)) >= 0) count++;
                hm.put(s2.charAt(start), hm.get(s2.charAt(start))+1);
            }
            if(hm.containsKey(s2.charAt(end))){
                if(hm.get(s2.charAt(end)) > 0) count--;
                hm.put(s2.charAt(end), hm.get(s2.charAt(end))-1);
            }
            start++;
            end++;
            if(count == 0) return true;
        }

        return false;
    }
}
