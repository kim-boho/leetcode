package Hard;

import Medium.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class VerticalOrderTraversalOfABinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> tm = new TreeMap<>();
        dfs(root,0,0,tm);
        List<List<Integer>> ans = new ArrayList<>();
        for(int key:tm.keySet()){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int key2:tm.get(key).keySet()){
                ArrayList<Integer> li = tm.get(key).get(key2);
                Collections.sort(li);
                for(int i:li) temp.add(i);
            }
            ans.add(temp);
        }
        return ans;
    }

    private void dfs(TreeNode node, int r, int c, TreeMap<Integer, TreeMap<Integer,ArrayList<Integer>>> tm){
        if(tm.containsKey(c)){
            if(tm.get(c).containsKey(r)){
                tm.get(c).get(r).add(node.val);
            } else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(node.val);
                tm.get(c).put(r,temp);
            }
        } else{
            TreeMap<Integer,ArrayList<Integer>> temp = new TreeMap<>();
            ArrayList<Integer> li = new ArrayList<>();
            li.add(node.val);
            temp.put(r,li);
            tm.put(c,temp);
        }
        if(node.left != null) dfs(node.left, r+1, c-1, tm);
        if(node.right != null) dfs(node.right, r+1, c+1, tm);
    }
}
