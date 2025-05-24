package Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindTheMostCommonResponse {
    public String findCommonResponse(List<List<String>> responses) {
        HashMap<String,Integer> hm = new HashMap();
        String max = null;
        int count = 0;
        for(List<String> li:responses){
            HashSet<String> hs = new HashSet();
            for(String s:li) hs.add(s);
            for(String s:hs){
                hm.put(s,hm.getOrDefault(s,0)+1);
                if(count < hm.get(s)){
                    max = s;
                    count = hm.get(s);
                } else if(count == hm.get(s)){
                    if(s.compareTo(max) < 0) max = s;
                }
            }
        }
        return max;
    }
}
