package Medium;

import java.util.ArrayList;
import java.util.HashMap;

public class ShortestWordDistance2 {
    HashMap<String, ArrayList<Integer>> wordAndIdxs;
    public ShortestWordDistance2(String[] wordsDict) {
        wordAndIdxs = new HashMap<>();
        for(int i=0; i<wordsDict.length; i++){
            String word = wordsDict[i];
            if(!wordAndIdxs.containsKey(word)){
                ArrayList<Integer> idxs = new ArrayList<>();
                wordAndIdxs.put(word,idxs);
            }
            wordAndIdxs.get(word).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> word1Idxs = wordAndIdxs.get(word1);
        ArrayList<Integer> word2Idxs = wordAndIdxs.get(word2);
        int i = 0;
        int j = 0;
        int shortestGap = Math.abs(word1Idxs.get(0)-word2Idxs.get(0));
        while(i < word1Idxs.size() && j < word2Idxs.size()){
            int num1 = word1Idxs.get(i);
            int num2 = word2Idxs.get(j);
            if(num1 < num2){
                while(i+1 < word1Idxs.size() && word1Idxs.get(i+1) < num2) i++;
                shortestGap = Math.min(shortestGap,num2-word1Idxs.get(i));
                i++;
            } else{
                while(j+1 < word2Idxs.size() && word2Idxs.get(j+1) < num1) j++;
                shortestGap = Math.min(shortestGap,num1-word2Idxs.get(j));
                j++;
            }
        }
        return shortestGap;
    }
}
