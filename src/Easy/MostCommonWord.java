package Easy;

import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> hs = new HashSet<>();
        for(String s:banned) hs.add(s.toLowerCase());
        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replaceAll("[\"!?',;.\"]"," ");
        String[] split = paragraph.split(" ");
        HashMap<String,Integer> hm = new HashMap<>();
        int max = 0;
        String ans = null;
        for(String s:split){
            if(!hs.contains(s) && s.length() != 0){
                hm.put(s,hm.getOrDefault(s,0)+1);
                if(max < hm.get(s)){
                    max = hm.get(s);
                    ans = s;
                }
            }
        }
        return ans;
    }
}
