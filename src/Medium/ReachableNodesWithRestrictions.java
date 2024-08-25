package Medium;

import java.util.HashMap;
import java.util.HashSet;

public class ReachableNodesWithRestrictions {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        boolean[] res = new boolean[n];
        for(int r:restricted) res[r] = true;
        HashMap<Integer, HashSet<Integer>> nodes = new HashMap<>();
        for(int[] e:edges){
            int e1 = e[0];
            int e2 = e[1];
            if(res[e1] || res[e2]) continue;
            if(nodes.containsKey(e1)){
                nodes.get(e1).add(e2);
            } else{
                HashSet<Integer> hs = new HashSet<>();
                hs.add(e2);
                nodes.put(e1,hs);
            }
            if(nodes.containsKey(e2)){
                nodes.get(e2).add(e1);
            } else{
                HashSet<Integer> hs = new HashSet<>();
                hs.add(e1);
                nodes.put(e2,hs);
            }
        }
        boolean[] check = new boolean[n];
        dfs(0,check,nodes);
        int ans = 0;
        for(boolean c:check) if(c) ans++;
        return ans;
    }

    private void dfs(int node, boolean[] check, HashMap<Integer, HashSet<Integer>> nodes){
        if(!check[node]){
            check[node] = true;
            if(!nodes.containsKey(node)) return;
            HashSet<Integer> next = nodes.get(node);
            for(int i:next){
                dfs(i,check,nodes);
            }
        }
    }
}
