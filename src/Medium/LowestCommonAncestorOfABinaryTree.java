package Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p == root || q == root) return root;
        HashMap<TreeNode,TreeNode> hm = new HashMap<>();
        hm.put(root, null);
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        while(qu.size()!=0){
            TreeNode temp = qu.poll();
            if(temp.left != null){
                hm.put(temp.left, temp);
                qu.add(temp.left);
            }
            if(temp.right != null){
                hm.put(temp.right, temp);
                qu.add(temp.right);
            }
        }

        HashSet<TreeNode> ance = new HashSet<>();
        TreeNode pointer = p;
        while(pointer != null){
            ance.add(pointer);
            pointer = hm.get(pointer);
        }

        pointer = q;
        while(pointer != null){
            if(ance.contains(pointer)) return pointer;
            pointer = hm.get(pointer);
        }

        return null;
    }
}
