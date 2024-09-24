package Medium;

import java.util.HashMap;
import java.util.HashSet;

public class CountLatticePointsInsideACircle {
    public int countLatticePoints(int[][] circles) {
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        for(int[] c:circles){
            int x = c[0];
            int y = c[1];
            int r = c[2];
            for(int i=x-r; i<=x+r; i++){
                for(int j=y-r; j<=y+r; j++){
                    double tempR = Math.sqrt((i-x)*(i-x)+(j-y)*(j-y));
                    if(tempR <= r){
                        if(hm.containsKey(i)) hm.get(i).add(j);
                        else{
                            HashSet<Integer> hs = new HashSet<>();
                            hs.add(j);
                            hm.put(i,hs);
                        }
                    }
                }
            }
        }
        int total = 0;
        for(int key:hm.keySet()){
            total += hm.get(key).size();
        }
        return total;
    }
}
