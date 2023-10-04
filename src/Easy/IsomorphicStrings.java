package Easy;

import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hm = new HashMap();
        HashSet<Character> checked = new HashSet();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            char c2 = t.charAt(i);
            if(!hm.containsKey(c)){
                if(!checked.contains(c2)){
                    hm.put(c, t.charAt(i));
                    checked.add(c2);
                }
                else return false;
            }
            else{
                if(hm.get(c) != t.charAt(i)) return false;
            }
        }
        return true;
    }
}
