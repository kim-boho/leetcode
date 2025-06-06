package Easy;

import java.util.Arrays;

public class MinimumDeletionsForAtMostKDistinctCharacters {
    public int minDeletion(String s, int k) {
        int[] chars = new int[26];
        int count = 0;
        for(char c:s.toCharArray()){
            chars[c-'a']++;
            if(chars[c-'a'] == 1) count++;
        }
        Arrays.sort(chars);
        int ans = 0;
        for(int i=0; i<chars.length && count > k; i++){
            if(chars[i] == 0) continue;
            else{
                ans += chars[i];
                count--;
            }
        }
        return ans;
    }
}
