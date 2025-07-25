package Medium;

import java.util.Arrays;

public class Hindex {
    public int hIndex(int[] citations) {
        int[] citationCount = new int[citations.length+1];
        for(int citation : citations){
            if(citation >= citations.length){
                citationCount[citations.length]++;
            } else{
                citationCount[citation]++;
            }
        }
        int maxHIndex = citations.length;
        int citatedPapers = 0;
        for(; maxHIndex > 0; maxHIndex--){
            citatedPapers += citationCount[maxHIndex];
            if(maxHIndex <= citatedPapers){
                return maxHIndex;
            }
        }
        return maxHIndex;
    }
}
