package Medium;

import java.util.HashMap;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0) return 0;
        HashMap<Character,Integer> appearedChars = new HashMap<>();
        char[] sChars = s.toCharArray();
        int left = 0;
        int right = 0;
        int ans = 0;
        while(right < sChars.length){
            while(right < sChars.length && appearedChars.size() <= k){
                appearedChars.put(sChars[right],appearedChars.getOrDefault(sChars[right],0)+1);
                right++;
            }
            ans = Math.max(appearedChars.size() <= k? right-left:right-left-1,ans);
            while(right < sChars.length && appearedChars.size() > k){
                if(appearedChars.get(sChars[left]) == 1){
                    appearedChars.remove(sChars[left]);
                } else{
                    appearedChars.put(sChars[left],appearedChars.get(sChars[left])-1);
                }
                left++;
            }
        }
        return ans;
    }
}
