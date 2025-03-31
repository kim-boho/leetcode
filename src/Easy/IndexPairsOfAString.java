package Easy;

import java.util.ArrayList;
import java.util.HashSet;

public class IndexPairsOfAString {
    public int[][] indexPairs(String text, String[] words) {
        HashSet<String>[] wordsByLength = new HashSet[51];
        for(String s:words){
            if(wordsByLength[s.length()] == null){
                HashSet<String> li = new HashSet<>();
                li.add(s);
                wordsByLength[s.length()] = li;
            } else wordsByLength[s.length()].add(s);
        }
        ArrayList<int[]> li = new ArrayList<>();
        for(int i=0; i<text.length(); i++){
            for(int j=1; j<wordsByLength.length; j++){
                if(wordsByLength[j] != null && i+j <= text.length()){
                    String sub =  text.substring(i,i+j);
                    HashSet<String> temp = wordsByLength[j];
                    if(temp.contains(sub)) li.add(new int[]{i,i+j-1});
                }
            }
        }
        int[][] ans = new int[li.size()][2];
        for(int i=0; i<li.size(); i++){
            int[] arr2 = li.get(i);
            ans[i][0] = arr2[0];
            ans[i][1] = arr2[1];
        }
        return ans;
    }
}
