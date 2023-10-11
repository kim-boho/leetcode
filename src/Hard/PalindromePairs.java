package Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<Integer, List<String>> listWithLen = new HashMap<>();
        HashMap<String,Integer> wordWithIdx = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<words.length; i++){
            wordWithIdx.put(words[i], i);
            if(listWithLen.containsKey(words[i].length())){
                listWithLen.get(words[i].length()).add(words[i]);
            } else{
                List<String> temp = new ArrayList();
                temp.add(words[i]);
                listWithLen.put(words[i].length(), temp);
            }
        }

        for(int i=0; i<words.length; i++){
            String word = words[i];
            for(Integer len: listWithLen.keySet()){
                List<String> temp = listWithLen.get(len);
                if(len == 0){
                    String word2 = temp.get(0);
                    if(!word.equals(word2) && isPalindrome(word)) add(word, word2, ans, wordWithIdx);
                } else if(len == word.length()){
                    String reverse = new StringBuilder(word).reverse().toString();
                    if(!word.equals(reverse) && wordWithIdx.get(reverse) != null) add(word, reverse, ans, wordWithIdx);
                } else if(len < word.length()){
                    String remaining = word.substring(len);
                    if(isPalindrome(remaining)){
                        String reversedFront = new StringBuilder(word.substring(0, len)).reverse().toString();
                        for(int j=0; j<temp.size(); j++){
                            String word2 = temp.get(j);
                            if(!word.equals(word2) && reversedFront.equals(word2)) add(word, word2, ans, wordWithIdx);
                        }
                    }
                } else{
                    for(int j=0; j<temp.size(); j++){
                        String word2 = temp.get(j);
                        String remaining2 = word2.substring(0, len - word.length());
                        if(isPalindrome(remaining2)){
                            String reversedBack = new StringBuilder(word2.substring(remaining2.length(), len)).reverse().toString();
                            if(reversedBack.equals(word)) add(word, word2, ans, wordWithIdx);
                        }
                    }
                }
            }
        }

        return ans;
    }

    private boolean isPalindrome(String s1){
        int start = 0;
        int end = s1.length()-1;
        while(start < end){
            if(s1.charAt(start++) != s1.charAt(end--)) return false;
        }
        return true;
    }

    private void add(String s1, String s2, List<List<Integer>> ans, HashMap<String,Integer> wordWithIdx){
        List<Integer> pair = new ArrayList<>();
        pair.add(wordWithIdx.get(s1));
        pair.add(wordWithIdx.get(s2));
        ans.add(pair);
    }
}
