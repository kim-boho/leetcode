package Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        int i = 10;
        List<String> ans = new ArrayList<>();
        HashSet<String> seenSubStrings = new HashSet<>();
        HashSet<String> addedToAns = new HashSet<>();
        while(i <= s.length()){
            String tempSubString = s.substring(i-10,i);
            if(!addedToAns.contains(tempSubString) && seenSubStrings.contains(tempSubString)){
                ans.add(tempSubString);
                addedToAns.add(tempSubString);
            }
            else seenSubStrings.add(tempSubString);
            i++;
        }
        return ans;
    }
}
