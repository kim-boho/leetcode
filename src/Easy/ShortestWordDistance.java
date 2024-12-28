package Easy;

public class ShortestWordDistance {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int i = -1;
        int j = -1;
        int ans = wordsDict.length;
        for(int k=0; k<wordsDict.length; k++){
            if(wordsDict[k].equals(word1)) i = k;
            if(wordsDict[k].equals(word2)) j = k;
            if(i != -1 && j != -1) ans = Math.min(Math.abs(i-j),ans);
        }
        return ans;
    }
}
