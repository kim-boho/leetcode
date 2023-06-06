package Medium;

import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for(int i=0; i<s.length(); i++){
            for(int j =0; j<wordDict.size(); j++){
                String st = wordDict.get(j);
                if(i == st.length()-1 && s.substring(0, i+1).equals(st)) dp[i] = true;
                else if(i-st.length() >= 0 && dp[i-st.length()] &&s.substring(i-st.length()+1, i+1).equals(st)) dp[i] = true;
            }
        }
        return dp[s.length()-1];
    }
}
