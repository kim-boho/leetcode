package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class TheEarliestMomentWhenEveryoneBecomeFriends {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs,(a, b) -> a[0]-b[0]);
        ArrayList<HashSet<Integer>> li = new ArrayList<>();
        for(int[] log:logs){
            int hs1 = -1;
            int hs2 = -1;
            for(int i=0; i<li.size(); i++){
                HashSet<Integer> hs = li.get(i);
                if(hs.contains(log[1])){
                    hs1 = i;
                } else if(hs.contains(log[2])){
                    hs2 = i;
                }
            }
            if(hs1 == -1 && hs2 == -1){
                HashSet<Integer> temp = new HashSet<>();
                temp.add(log[1]);
                temp.add(log[2]);
                li.add(temp);
            } else{
                if(hs1 == -1){
                    li.get(hs2).add(log[1]);
                    if(li.get(hs2).size() == n) return log[0];
                } else if(hs2 == -1){
                    li.get(hs1).add(log[2]);
                    if(li.get(hs1).size() == n) return log[0];
                } else{
                    li.get(hs1).addAll(li.get(hs2));
                    if(li.get(hs1).size() == n) return log[0];
                    li.remove(hs2);
                }
            }
        }
        return -1;
    }
}
