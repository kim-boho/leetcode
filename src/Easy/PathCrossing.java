package Easy;

import java.util.HashMap;
import java.util.HashSet;

public class PathCrossing {
    public boolean isPathCrossing(String path) {
        char[] arr = path.toCharArray();
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        int x = 0;
        int y = 0;
        HashSet<Integer> zero = new HashSet<>();
        zero.add(0);
        hm.put(0,zero);
        for(char c:arr){
            if(c == 'N') y++;
            else if(c == 'S') y--;
            else if(c == 'W') x--;
            else x++;
            if(hm.containsKey(x)){
                if(hm.get(x).contains(y)) return true;
                else hm.get(x).add(y);
            } else{
                HashSet<Integer> temp = new HashSet<>();
                temp.add(y);
                hm.put(x,temp);
            }
        }
        return false;
    }
}
