package Medium;

import java.util.ArrayList;
import java.util.HashSet;

public class LexicographicallySmallestEquivalentString {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] rep = new int[26];
        for(int i=0; i<rep.length; i++) rep[i] = i;
        for(int i=0; i<s1.length(); i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            int rep1 = findRep(rep,c1-'a');
            int rep2 = findRep(rep,c2-'a');
            if(rep1 < rep2) rep[rep2] = rep1;
            else if(rep1 > rep2) rep[rep1] =rep2;
        }
        StringBuilder sb = new StringBuilder();
        for(char c:baseStr.toCharArray()){
            int r = findRep(rep,c-'a');
            sb.append((char)('a'+r));
        }
        return sb.toString();
    }

    private int findRep(int[] rep, int target){
        if(rep[target] == target) return target;
        return findRep(rep,rep[target]);
    }
}
