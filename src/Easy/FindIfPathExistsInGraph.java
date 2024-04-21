package Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        boolean[] check = new boolean[n];
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        for(int[] e:edges){
            int n1 = e[0];
            int n2 = e[1];
            if(hm.containsKey(n1)) hm.get(n1).add(n2);
            else{
                HashSet<Integer> hs = new HashSet<>();
                hs.add(n2);
                hm.put(n1,hs);
            }
            if(hm.containsKey(n2)) hm.get(n2).add(n1);
            else{
                HashSet<Integer> hs = new HashSet<>();
                hs.add(n1);
                hm.put(n2,hs);
            }
        }
        if(hm.containsKey(source) && hm.get(source).contains(destination)) return true;
        if(!hm.containsKey(destination)) return false;
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while(!q.isEmpty()){
            Queue<Integer> temp = new LinkedList<>();
            while(!q.isEmpty()){
                int node = q.poll();
                if(node == destination) return true;
                check[node] = true;
                HashSet<Integer> needCheck = hm.get(node);
                for(Integer i:needCheck){
                    if(!check[i]) temp.add(i);
                    if(i == destination) return true;
                }
            }
            q = temp;
        }
        return false;
    }
}
