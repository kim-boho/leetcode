package Medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        HashSet<Integer>[] lis = new HashSet[n];
        for(int i=0; i<lis.length; i++){
            lis[i] = new HashSet<>();
        }
        for(int[] e:edges){
            lis[e[0]].add(e[1]);
            lis[e[1]].add(e[0]);
        }
        boolean[] checked = new boolean[n];
        checked[0] = true;
        int[] parents = new int[n];
        Arrays.fill(parents,-1);
        Queue<Integer> curr = new ArrayDeque<>();
        curr.add(0);
        while(!curr.isEmpty()){
            Queue<Integer> temp = new ArrayDeque<>();
            while(!curr.isEmpty()){
                int node = curr.poll();
                for(int e:lis[node]){
                    if(checked[e] && parents[node] != e) return false;
                    else if(!checked[e]){
                        parents[e] = node;
                        checked[e] = true;
                        temp.add(e);
                    }
                }
            }
            curr = temp;
        }
        for(boolean b:checked) if(!b) return false;
        return true;
    }
}
