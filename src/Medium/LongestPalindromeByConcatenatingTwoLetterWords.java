package Medium;

import java.util.HashMap;

public class LongestPalindromeByConcatenatingTwoLetterWords {
    public int longestPalindrome(String[] words) {
        int ans = 0;
        HashMap<String,Integer> hm = new HashMap<>();
        for(String s:words){
            StringBuilder sb = new StringBuilder(s);
            String rv = sb.reverse().toString();
            if(hm.containsKey(rv)){
                if(hm.get(rv) == 1) hm.remove(rv);
                else hm.put(rv,hm.get(rv)-1);
                ans += 4;
            } else hm.put(s,hm.getOrDefault(s,0)+1);
        }
        for(String s:hm.keySet()){
            if(s.charAt(0) == s.charAt(1)){
                ans+=2;
                break;
            }
        }
        return ans;
    }
}
