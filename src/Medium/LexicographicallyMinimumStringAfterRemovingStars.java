package Medium;

import java.util.PriorityQueue;

public class LexicographicallyMinimumStringAfterRemovingStars {
    public String clearStars(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a,b) ->{
                    if(a[0] == b[0]) return b[1]-a[1];
                    else return a[0]-b[0];
                }
        );
        char[] chars = s.toCharArray();
        for(int i=0; i<chars.length; i++){
            if(chars[i] == '*'){
                if(!pq.isEmpty()){
                    int[] temp = pq.poll();
                    chars[temp[1]] = '*';
                }
            } else{
                int[] temp = {chars[i],i};
                pq.add(temp);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : chars){
            if(c != '*') sb.append(c);
        }
        return sb.toString();
    }
}
