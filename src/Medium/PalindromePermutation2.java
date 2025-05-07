package Medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePermutation2 {
    public List<String> generatePalindromes(String s) {
        int[] count = new int[26];
        for(int i=0; i<s.length(); i++) count[s.charAt(i)-'a']++;
        int odd = 0;
        int halfCount = 0;
        String mid = "";
        for(int i=0; i<26; i++){
            if(count[i] % 2 == 1){
                odd++;
                if(mid.equals("")) mid = String.valueOf((char)(i+'a'));
            }
            count[i] /= 2;
            halfCount += count[i];
        }
        List<String> ans = new ArrayList<>();
        char[] chars = new char[halfCount];
        if(odd > 1) return ans;
        dfs(count,ans,mid,chars,0);
        return ans;
    }

    private void dfs(int[] count, List<String> ans, String mid, char[] chars, int idx){
        if(idx == chars.length){
            StringBuilder sb = new StringBuilder();
            for(char c:chars) sb.append(c);
            sb.append(mid);
            for(int i=chars.length-1; i>=0; i--){
                sb.append(chars[i]);
            }
            ans.add(sb.toString());
            return;
        }
        for(int i=0; i<count.length; i++){
            if(count[i] != 0){
                count[i]--;
                chars[idx] = (char)(i+'a');
                dfs(count,ans,mid,chars,idx+1);
                count[i]++;
            }
        }
    }
}
