package Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SentenceSimilarity {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if(sentence1.length != sentence2.length) return false;
        HashMap<String, HashSet<String>> hm = new HashMap<>();
        for(List<String> li:similarPairs){
            if(hm.containsKey(li.get(0))){
                hm.get(li.get(0)).add(li.get(1));
            } else{
                HashSet<String> hs = new HashSet<>();
                hs.add(li.get(1));
                hm.put(li.get(0),hs);
            }
        }
        for(int i=0; i<sentence1.length; i++){
            String s = sentence1[i];
            String s2 = sentence2[i];
            if(!(hm.containsKey(s) && hm.get(s).contains(s2)) && !(hm.containsKey(s2) && hm.get(s2).contains(s)) && !s.equals(s2)) return false;
        }
        return true;
    }
}
