package Easy;

import java.util.ArrayList;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequence1 {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        int start = groups[0];
        ans.add(words[0]);
        for(int i=1; i<groups.length; i++){
            if(groups[i] != start){
                ans.add(words[i]);
                start = groups[i];
            }
        }
        return ans;
    }
}
