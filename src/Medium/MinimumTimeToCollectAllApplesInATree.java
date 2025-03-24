package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MinimumTimeToCollectAllApplesInATree {
    List<Boolean> hasApple;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        if(edges.length == 0) return 0;
        this.hasApple = hasApple;
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        for(int[] e:edges){
            int l = e[0];
            int r = e[1];
            if(!hm.containsKey(l)) hm.put(l,new HashSet<>());
            hm.get(l).add(r);
            if(!hm.containsKey(r)) hm.put(r,new HashSet<>());
            hm.get(r).add(l);
        }
        ArrayList<Integer> li = new ArrayList<>();
        li.add(0);
        while(li.size() > 0){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i:li){
                HashSet<Integer> nexts = hm.get(i);
                for(int j:nexts){
                    hm.get(j).remove(i);
                    temp.add(j);
                }
            }
            li = temp;
        }
        TreeNode2[] tnArr = new TreeNode2[n];
        for(int i=0; i<n; i++){
            tnArr[i] = new TreeNode2(i);
        }
        for(int key:hm.keySet()){
            HashSet<Integer> hs = hm.get(key);
            ArrayList<TreeNode2> tnLi = (ArrayList<TreeNode2>) tnArr[key].children;
            for(int i:hs){
                tnLi.add(tnArr[i]);
            }
        }
        return calculateDist(tnArr[0]);
    }
    private int calculateDist(TreeNode2 tn){
        if(tn.children.size() == 0){
            if(hasApple.get(tn.val)) return 2;
            else return 0;
        }
        int sum = 0;
        for(TreeNode2 t:tn.children){
            sum += calculateDist(t);
        }
        if(sum == 0 && !hasApple.get(tn.val)) return 0;
        else{
            if(tn.val == 0) return sum;
            else return sum+2;
        }
    }
}
