package Easy;

import java.util.HashSet;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if(pattern.length() != arr.length) return false;
        HashSet<String> hs = new HashSet();
        String[] arr2 = new String[26];
        for(int i=0; i<arr.length; i++){
            char c = pattern.charAt(i);
            String st = arr[i];
            if(arr2[c-'a'] == null){
                if(hs.contains(st)) return false;
                hs.add(st);
                arr2[c-'a'] = st;
            }
            else{
                if(!arr2[c-'a'].equals(st)) return false;
            }
        }

        return true;

    }
}
