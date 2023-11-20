package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        int[] lower = new int[26];
        int[] upper = new int[26];
        int[] digits = new int[10];

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c >= 'A' && c <= 'Z') upper[c-'A']++;
            else if(c >= 'a' && c <= 'z') lower[c-'a']++;
            else digits[c-'0']++;
        }

        TreeMap<Integer, ArrayList<Character>> tm = new TreeMap<>(Collections.reverseOrder());
        for(int i=0; i<26; i++){
            if(lower[i] != 0){
                if(tm.containsKey(lower[i])) tm.get(lower[i]).add((char)('a'+i));
                else{
                    ArrayList<Character> li = new ArrayList<>();
                    li.add((char)('a'+i));
                    tm.put(lower[i], li);
                }
            }
            if(upper[i] != 0){
                if(tm.containsKey(upper[i])) tm.get(upper[i]).add((char)('A'+i));
                else{
                    ArrayList<Character> li = new ArrayList<>();
                    li.add((char)('A'+i));
                    tm.put(upper[i], li);
                }
            }
        }

        for(int i=0; i<10; i++){
            if(tm.containsKey(digits[i])) tm.get(digits[i]).add((char)('0'+i));
            else{
                ArrayList<Character> li = new ArrayList<>();
                li.add((char)('0'+i));
                tm.put(digits[i], li);
            }
        }

        Iterator<Integer> it = tm.keySet().iterator();
        StringBuilder sb = new StringBuilder();
        while(it.hasNext()){
            int n = (int) it.next();
            ArrayList<Character> temp = tm.get(n);
            for (char c : temp) {
                for (int j = 0; j < n; j++) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}
