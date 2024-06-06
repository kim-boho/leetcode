package Easy;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {
    public List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();
        int[][] chars = new int[words.length][26];
        for(int i=0; i<words.length; i++){
            String s = words[i];
            char[] temp = s.toCharArray();
            for(char c:temp){
                chars[i][c-'a']++;
            }
        }
        for(int i=0; i<26; i++){
            int min = chars[0][i];
            for(int j=1; j<chars.length; j++){
                if(min>chars[j][i]) min = chars[j][i];
            }
            if(min != 0){
                while(min-- > 0) ans.add(String.valueOf((char)('a'+i)));
            }
        }
        return ans;
    }
}
