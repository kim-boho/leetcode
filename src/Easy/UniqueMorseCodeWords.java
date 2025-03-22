package Easy;

import java.util.HashSet;

public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        if(words.length == 1) return 1;
        String[] morse = {".-","-...","-.-.","-..",".","..-."
                ,"--.","....","..",".---","-.-",".-..","--","-.","---"
                ,".--.","--.-",".-.","...","-","..-","...-",".--"
                ,"-..-","-.--","--.."};
        HashSet<String> hs = new HashSet<>();
        for(String s:words){
            char[] ch = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            for(char c:ch){
                sb.append(morse[c-'a']);
            }
            hs.add(sb.toString());
        }
        return hs.size();
    }
}
