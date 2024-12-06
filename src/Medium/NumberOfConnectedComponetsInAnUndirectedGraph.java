package Medium;

import java.util.Arrays;
import java.util.HashSet;

public class NumberOfConnectedComponetsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        int[] groups = new int[n];
        Arrays.fill(groups,-1);
        int setNum = 0;
        for(int[] e:edges){
            int e1 = groups[e[0]];
            int e2 = groups[e[1]];
            if(e1 != -1 && e2 == -1) groups[e[1]] = groups[e[0]];
            else if(e2 != -1 && e1 == -1) groups[e[0]] = groups[e[1]];
            else if(e1 == -1 && e1 == -1){
                groups[e[0]] = setNum;
                groups[e[1]] = setNum++;
            } else{
                for(int i=0; i<groups.length; i++){
                    if(groups[i] == e2) groups[i] = e1;
                }
            }
        }
        HashSet<Integer> hs = new HashSet<>();
        int islandCount = 0;
        for(int num:groups){
            if(num != -1) hs.add(num);
            else islandCount++;
        }
        return hs.size()+islandCount;
    }
}
