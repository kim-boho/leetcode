package Medium;

import java.util.HashMap;

public class CreateBinaryTreeFromDescriptions {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> hm = new HashMap<>();
        HashMap<Integer, Integer> parents = new HashMap<>();

        for(int[] d:descriptions){
            if(!parents.containsKey(d[0])) parents.put(d[0],null);

            TreeNode t;
            if(hm.containsKey(d[0])) t = hm.get(d[0]);
            else{
                t = new TreeNode(d[0]);
                hm.put(d[0],t);
            }

            TreeNode child;
            if(hm.containsKey(d[1])) child = hm.get(d[1]);
            else{
                child = new TreeNode(d[1]);
                hm.put(d[1],child);
            }

            if(d[2] == 0) t.right = child;
            else t.left = child;

            parents.put(d[1],d[0]);
        }

        for(int key:parents.keySet()){
            if(parents.get(key) == null) return hm.get(key);
        }

        return null;
    }
}
