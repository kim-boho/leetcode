package Easy;

public class CountingWordsWithAGivenPrefix {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for(String s:words){
            if(s.indexOf(pref) == 0) ans++;
        }
        return ans;
    }
}
