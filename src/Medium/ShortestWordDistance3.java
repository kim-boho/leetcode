package Medium;

public class ShortestWordDistance3 {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int word1Idx = -1;
        int word2Idx = -1;
        int i =0;
        while(i < wordsDict.length && (word1Idx == -1 || word2Idx == -1)){
            if(word1Idx == -1 && wordsDict[i].equals(word1)) word1Idx = i;
            else if(word2Idx == -1 && wordsDict[i].equals(word2)) word2Idx = i;
            i++;
        }
        boolean isEqual = word1.equals(word2);
        int minDist = Math.abs(word1Idx-word2Idx);
        while(word1Idx < wordsDict.length && word2Idx < wordsDict.length){
            if(word1Idx < word2Idx){
                if(isEqual) word1Idx = word2Idx+1;
                else word1Idx++;
                while(word1Idx < wordsDict.length && !wordsDict[word1Idx].equals(word1)) word1Idx++;
            } else{
                if(isEqual) word2Idx = word1Idx+1;
                else word2Idx++;
                while(word2Idx < wordsDict.length && !wordsDict[word2Idx].equals(word2)) word2Idx++;
            }
            if(word1Idx < wordsDict.length && word2Idx < wordsDict.length) minDist = Math.min(minDist,Math.abs(word1Idx-word2Idx));
        }
        return minDist;
    }
}
