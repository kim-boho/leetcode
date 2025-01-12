package Medium;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] chars = new int[26];
        List<String> ans = new ArrayList<>();
        for(String s:words2){
            char[] arr = s.toCharArray();
            int[] temp = new int[26];
            for(char c:arr) temp[c-'a']++;
            for(int i=0; i<26; i++){
                chars[i] = Math.max(chars[i],temp[i]);
            }
        }
        for(String s:words1){
            char[] arr = s.toCharArray();
            int[] temp = new int[26];
            for(char c:arr) temp[c-'a']++;
            boolean isUniversal = true;
            for(int i=0; i<26 && isUniversal; i++){
                if(temp[i] < chars[i]) isUniversal = false;
            }
            if(isUniversal) ans.add(s);
        }
        return ans;
    }
}
