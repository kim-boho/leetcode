package Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indexes = new ArrayList<>();
        HashMap<String, Integer> wordsOccurence = removeDuplicateFromArray(words);
        int wordLen = words[0].length();
        int sumOfLenOfWords = words.length * wordLen;
        if(isOnlyOneCharArray(words,s)){
            for(int i=0; i<s.length()-sumOfLenOfWords+1; i++) indexes.add(i);
            return indexes;
        }
        for(int i=0; i<s.length() - sumOfLenOfWords + 1; i++){
            int startIndexInS = i;
            HashMap<String, Integer> countedWord = new HashMap<>();
            int validWordCount = 0;
            while(startIndexInS < i + sumOfLenOfWords){
                String subStingFromS = s.substring(startIndexInS,startIndexInS + wordLen);
                if(wordsOccurence.containsKey(subStingFromS)){
                    countedWord.put(subStingFromS,countedWord.getOrDefault(subStingFromS,0)+1);
                    if(countedWord.get(subStingFromS) > wordsOccurence.get(subStingFromS)) break;
                    else validWordCount++;
                } else break;
                startIndexInS += wordLen;
            }
            if(validWordCount == words.length) indexes.add(i);
        }
        return indexes;
    }

    private HashMap<String,Integer> removeDuplicateFromArray(String[] words){
        HashMap<String, Integer> wordsOccurence = new HashMap<>();
        for(String word:words) wordsOccurence.put(word,wordsOccurence.getOrDefault(word,0)+1);
        return wordsOccurence;
    }

    private boolean isOnlyOneCharArray(String[] words, String s){
        char onlyPossibleChar = s.charAt(0);
        for(String word : words){
            for(char c : word.toCharArray()){
                if(c != onlyPossibleChar) return false;
            }
        }
        for(char c : s.toCharArray()){
            if(c != onlyPossibleChar) return false;
        }
        return true;
    }
}
