package Medium;

import java.util.HashSet;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            int[] freq = new int[26];
            int temp = i;
            HashSet<Character> hs = new HashSet<>();
            int total = 0;
            int count = 0;
            while(temp<s.length()){
                char c = s.charAt(temp);
                freq[c-'a']++;
                if(hs.contains(c)){
                    if(freq[c-'a']<=k) count++;
                } else{
                    hs.add(c);
                    count++;
                    total += k;
                }
                if(count == total && ans < temp-i+1) ans = temp-i+1;
                temp++;
            }
        }
        return ans;
    }
}
