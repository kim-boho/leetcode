package Easy;

import java.util.Arrays;

public class LargestSubstringBetweenTwoEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        char[] arr = s.toCharArray();
        int ans = -1;
        int[] alphabet = new int[26];
        Arrays.fill(alphabet,-1);
        for(int i=0; i<arr.length; i++){
            int c = arr[i]-'a';
            if(alphabet[c] == -1) alphabet[c] = i;
            else ans = Math.max(i-alphabet[c]-1,ans);
        }
        return ans;
    }
}
