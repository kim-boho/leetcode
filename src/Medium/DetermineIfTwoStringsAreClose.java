package Medium;

import java.util.HashMap;

public class DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        int len = word1.length();
        int needFix = 0;
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int[] chars1 = new int[26];
        int[] chars2 = new int[26];
        for(char c:arr1) chars1[c-'a']++;
        for(char c:arr2){
            if(chars1[c-'a'] == 0) return false;
            chars2[c-'a']++;
        }
        HashMap<Integer, Integer> occ = new HashMap();
        for(int i:chars1){
            if(i == 0) continue;
            if(occ.containsKey(i)) occ.put(i, occ.get(i)+1);
            else occ.put(i, 1);
        }
        for(int i:chars2){
            if(i == 0) continue;
            if(!occ.containsKey(i) || occ.get(i) == 0) return false;
            occ.put(i, occ.get(i)-1);
        }
        return true;
    }
}
