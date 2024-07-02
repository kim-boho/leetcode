package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class AllAncestorsOfANodeInADirectedAcyclicGraph {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<Integer>[] sets = new HashSet[n];
        for(int i=0; i<n; i++) sets[i] = new HashSet<Integer>();

        for(int[] e:edges) sets[e[1]].add(e[0]);

        for(int i=0; i<n; i++){
            if(sets[i].isEmpty()) ans.add(new ArrayList<Integer>());
            else{
                HashSet<Integer> checked = new HashSet<>(sets[i]);
                HashSet<Integer> ances = new HashSet<>(sets[i]);
                while(!checked.isEmpty()){
                    HashSet<Integer> temp = new HashSet<>();
                    for(Integer j:checked){
                        ances.addAll(sets[j]);
                        temp.addAll(sets[j]);
                    }
                    checked = temp;
                }
                List<Integer> li = new ArrayList<>(ances);
                Collections.sort(li);
                ans.add(li);
            }
        }
        return ans;
    }
}
