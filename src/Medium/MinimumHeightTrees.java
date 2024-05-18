package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if(n==1){
            ans.add(0);
            return ans;
        }
        ArrayList<Integer>[] nodes = new ArrayList[n];
        int[] count = new int[n];
        for(int i=0; i<edges.length; i++){
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            count[n1]++;
            count[n2]++;
            if(nodes[n1] == null) nodes[n1] = new ArrayList<>();
            if(nodes[n2] == null) nodes[n2] = new ArrayList<>();
            nodes[n1].add(n2);
            nodes[n2].add(n1);
        }
        Queue<Integer> q = new LinkedList();
        for(int i=0; i<n; i++){
            if(count[i]==1) q.add(i);
        }

        int allNodes = n;
        while(allNodes > 2){
            int s = q.size();
            allNodes -= s;
            for(int i=0; i<s; i++){
                for(int adj:nodes[q.poll()]){
                    count[adj]--;
                    if(count[adj]==1){
                        q.add(adj);
                    }
                }
            }
        }
        ans.addAll(q);
        return ans;
    }
}
