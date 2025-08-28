package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> dictionary) {
        char[][] charDictionary = new char[dictionary.size()][];
        for(int i=0; i<dictionary.size(); i++){
            charDictionary[i] = dictionary.get(i).toCharArray();
        }

        HashMap<Integer,Integer>[] nextCharsWithIndex = new HashMap[26];
        for(int i=0; i<26; i++) nextCharsWithIndex[i] = new HashMap<>();

        for(int i=0; i<charDictionary.length; i++){
            char startChar = charDictionary[i][0];
            nextCharsWithIndex[startChar-'a'].put(i,0);
        }

        int longestWordLen = 0;
        ArrayList<String> candidates = new ArrayList<>();
        for(char c:s.toCharArray()){
            HashMap<Integer,Integer> charsToMoveIndex = nextCharsWithIndex[c-'a'];
            ArrayList<Integer> keyList = new ArrayList<>(charsToMoveIndex.keySet());
            for(int idx:keyList){
                int pointer = charsToMoveIndex.get(idx);
                charsToMoveIndex.remove(idx);
                if(pointer+1 == charDictionary[idx].length){
                    if(longestWordLen <= charDictionary[idx].length){
                        if(longestWordLen < charDictionary[idx].length) candidates = new ArrayList<>();
                        longestWordLen = charDictionary[idx].length;
                        candidates.add(dictionary.get(idx));
                    }
                } else{
                    char nextChar = charDictionary[idx][pointer+1];
                    nextCharsWithIndex[nextChar-'a'].put(idx,pointer+1);
                }
            }
        }
        if(candidates.size() == 0) return "";
        String ans = candidates.get(0);
        for(int i=1; i<candidates.size(); i++){
            if(ans.compareTo(candidates.get(i)) > 0) ans = candidates.get(i);
        }
        return ans;
    }
}
