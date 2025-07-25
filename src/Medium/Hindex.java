package Medium;

import java.util.Arrays;

public class Hindex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int hIndex = 0;
        for(int i=citations.length-1; i>=0; i--){
            if(citations[i] < hIndex+1){
                break;
            } else{
                hIndex++;
            }
        }
        return hIndex;
    }
}
