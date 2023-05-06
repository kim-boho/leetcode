package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> li = new ArrayList<>();
        inorderTrav(root, q, li);
        Collections.sort(li);
        for(int i=0; i<li.size(); i++){
            TreeNode n = q.poll();
            n.val = li.get(i);
        }
    }

    private void inorderTrav(TreeNode node, Queue<TreeNode> q, ArrayList<Integer> li){
        if(node != null){
            if(node.left != null) inorderTrav(node.left, q, li);
            q.add(node);
            li.add(node.val);
            if(node.right != null) inorderTrav(node.right, q, li);
        }
    }
}
