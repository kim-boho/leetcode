package Medium;

import java.util.HashSet;

public class LongestUncommonSubsequence2 {
    public int findLUSlength(String[] strs) {
        HashSet<String> duplicated = new HashSet<>();
        HashSet<String> words = new HashSet<>();
        for(String s:strs){
            if(words.contains(s)) duplicated.add(s);
            else words.add(s);
        }

        HashSet<String> once = new HashSet<>();
        HashSet<String> twiceOrMore = new HashSet<>();

        for(String dupl:duplicated){
            char[] chars = dupl.toCharArray();
            StringBuilder sb = new StringBuilder();
            HashSet<String> subs = new HashSet<>();
            makeSubSeqString(sb,chars,0,subs);
            twiceOrMore.addAll(subs);
            words.removeAll(subs);
        }
        for(String s:words){
            char[] chars = s.toCharArray();
            HashSet<String> subs = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            makeSubSeqString(sb,chars,0,subs);
            subs.removeAll(twiceOrMore);
            for(String sub:subs){
                if(once.contains(sub)) twiceOrMore.add(sub);
                else once.add(sub);
            }
        }
        int ans = 0;
        for(String s:once){
            ans = Math.max(ans,s.length());
        }
        return ans == 0? -1:ans;
    }

    private void makeSubSeqString(StringBuilder sb, char[] chars, int idx, HashSet<String> subs){
        if(idx == chars.length){
            if(sb.length() > 0) subs.add(sb.toString());
            return;
        }
        sb.append(chars[idx]);
        makeSubSeqString(sb,chars,idx+1,subs);
        sb.deleteCharAt(sb.length()-1);
        makeSubSeqString(sb,chars,idx+1,subs);
    }
}
