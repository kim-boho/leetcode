package Easy;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for(int i=0; i<26; i++) freq[i] = -1;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(freq[c-'a']==-1) freq[c-'a'] = i;
            else freq[c-'a'] = -2;
        }

        int ans = s.length();
        for(int i:freq){
            if(i>-1){
                if(ans>i) ans = i;
            }
        }
        return ans == s.length()? -1:ans;
    }
}
