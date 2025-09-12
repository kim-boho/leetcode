package Medium;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    List<List<Integer>> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        boolean[] checked = new boolean[graph.length];
        dfs(checked,graph,0,path);
        return ans;
    }

    private void dfs(boolean[] checked, int[][] graph, int idx, ArrayList<Integer> path){
        if(checked[idx]) return;
        path.add(idx);
        if(idx == checked.length-1){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(path);
            ans.add(temp);
            path.remove(path.size()-1);
            return;
        }
        checked[idx] = true;
        for(int nextNode:graph[idx]){
            dfs(checked,graph,nextNode,path);
        }
        path.remove(path.size()-1);
        checked[idx] = false;
    }
}
