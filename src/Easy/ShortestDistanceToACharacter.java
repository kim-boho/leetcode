package Easy;

import java.util.ArrayList;

public class ShortestDistanceToACharacter {
    public int[] shortestToChar(String s, char c) {
        int[] ans = new int[s.length()];
        char[] sChar = s.toCharArray();
        ArrayList<Integer> cs = new ArrayList<>();
        for(int i=0; i<sChar.length; i++){
            if(sChar[i] == c){
                cs.add(i);
            }
        }
        for(int i=cs.get(0)-1; i>=0; i--) ans[i] = ans[i+1]+1;
        for(int i=0; i+1<cs.size(); i++){
            int start = cs.get(i)+1;
            int end = cs.get(i+1)-1;
            int dist = 1;
            while(start <= end){
                ans[start] = dist;
                ans[end] = dist;
                start++;
                end--;
                dist++;
            }
        }
        for(int i=cs.get(cs.size()-1)+1; i<ans.length; i++) ans[i] = ans[i-1]+1;
        return ans;
    }
}
