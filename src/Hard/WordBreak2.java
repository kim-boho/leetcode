package Hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>();
        for(String st:wordDict) hs.add(st);
        List<String> ans = new ArrayList<>();
        List<String> words = new ArrayList<>();
        dfs(0, s, hs, words, ans);

        return ans;
    }

    private void dfs(int count, String s, HashSet<String> hs, List<String> words, List<String> ans){
        if(count == s.length()){
            String st = "";
            for(String str:words) st += str+" ";
            ans.add(st.trim());
            return;
        }
        StringBuilder sb = new StringBuilder("");
        for(int i=count; i<s.length(); i++){
            sb.append(s.charAt(i));
            String temp = sb.toString();
            System.out.println(temp);
            if(hs.contains(temp)){
                words.add(temp);
                dfs(i+1, s, hs, words, ans);
                words.remove(words.size()-1);
            }
        }
    }
}
