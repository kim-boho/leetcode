package Medium;

import java.util.ArrayList;
import java.util.HashSet;

public class LexicographicallySmallestEquivalentString {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        ArrayList<HashSet<Character>> li = new ArrayList<>();
        for(int i=0; i<s1.length(); i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(c1 == c2) continue;
            HashSet<Character> hs1 = null;
            HashSet<Character> hs2 = null;
            for(HashSet<Character> hs:li){
                if(hs.contains(c1)){
                    hs.add(c1);
                    hs1 = hs;
                } else if(hs.contains(c2)){
                    hs.add(c2);
                    hs2 = hs;
                }
            }
            if(hs1 == null && hs2 == null){
                HashSet<Character> hs = new HashSet<>();
                hs.add(c1);
                hs.add(c2);
                li.add(hs);
            } else if(hs1 == null){
                hs2.add(c1);
            } else if(hs2 == null){
                hs1.add(c2);
            } else{
                hs1.addAll(hs2);
                li.remove(hs2);
            }
        }
        char[] rep = new char[26];
        for(int i=0; i<rep.length; i++){
            rep[i] = (char)('a'+i);
        }
        for(HashSet<Character> hs:li){
            char repr = 'z';
            for(char c:hs){
                repr = (char)Math.min(c,repr);
            }
            for(char c:hs){
                rep[c-'a'] = repr;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c:baseStr.toCharArray()){
            sb.append(rep[c-'a']);
        }
        return sb.toString();
    }
}
