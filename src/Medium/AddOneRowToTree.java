package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode newTreeNode = new TreeNode(val);
            newTreeNode.left = root;
            return newTreeNode;
        }
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        TreeNode cur = root;

        while(depth-- > 2){
            Queue<TreeNode> temp = new LinkedList();
            while(q.size() > 0){
                TreeNode t = q.poll();
                if(t.left != null) temp.add(t.left);
                if(t.right != null) temp.add(t.right);
            }
            if(temp.size() == 0) break;
            q = temp;
        }

        while(q.size() > 0){
            TreeNode t = q.poll();
            if(t.left == null && t.right == null){
                TreeNode newTreeNode = new TreeNode(val);
                t.left = newTreeNode;
                TreeNode newTreeNode2 = new TreeNode(val);
                t.right = newTreeNode2;
            } else{
                if(t.left != null){
                    TreeNode temp = t.left;
                    TreeNode newTreeNode = new TreeNode(val);
                    t.left = newTreeNode;
                    newTreeNode.left = temp;
                }
                if(t.right != null){
                    TreeNode temp = t.right;
                    TreeNode newTreeNode = new TreeNode(val);
                    t.right = newTreeNode;
                    newTreeNode.right = temp;
                }
                if(t.left == null){
                    TreeNode newTreeNode = new TreeNode(val);
                    t.left = newTreeNode;
                }
                if(t.right == null){
                    TreeNode newTreeNode = new TreeNode(val);
                    t.right = newTreeNode;
                }
            }
        }

        return root;
    }
}
