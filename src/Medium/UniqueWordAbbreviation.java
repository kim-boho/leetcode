package Medium;

import java.util.HashMap;

public class UniqueWordAbbreviation {
    HashMap<Integer,String>[][] lengthWithWord;
    public UniqueWordAbbreviation(String[] dictionary) {

        lengthWithWord = new HashMap[26][26];

        for(String s:dictionary){

            int start = s.charAt(0)-'a';
            int end = s.charAt(s.length()-1)-'a';

            if(lengthWithWord[start][end] == null) lengthWithWord[start][end] = new HashMap<>();

            if(!lengthWithWord[start][end].containsKey(s.length())){
                lengthWithWord[start][end].put(s.length(),s);
            } else{
                String prevWord = lengthWithWord[start][end].get(s.length());
                if(prevWord.equals("*")) continue;
                else if(!prevWord.equals(s)) lengthWithWord[start][end].put(s.length(),"*");
            }
        }

    }

    public boolean isUnique(String word) {
        int start = word.charAt(0)-'a';
        int end = word.charAt(word.length()-1)-'a';

        if(lengthWithWord[start][end] == null || !lengthWithWord[start][end].containsKey(word.length())) return true;
        if(lengthWithWord[start][end].get(word.length()).equals(word)) return true;

        return false;
    }
}
