package Easy;

import Medium.TreeNode;

public class IncreasingOrderSearchTree {
    TreeNode par = null;
    TreeNode ans = null;
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return ans;
    }

    private void inorder(TreeNode node){
        if(node.left != null){
            TreeNode tn = node.left;
            node.left = null;
            inorder(tn);
        }
        if(par == null){
            par = node;
            ans = node;
        }
        else{
            par.right = node;
            par = node;
        }
        if(node.right != null){
            inorder(node.right);
        }
    }
}
