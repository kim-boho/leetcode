package Easy;

import Medium.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode node){
        if(node == null) return;
        if(node.left != null && node.right != null){
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            invert(node.right);
            invert(node.left);
        } else if(node.left != null){
            node.right = node.left;
            node.left = null;
            invert(node.right);
        } else if(node.right != null){
            node.left = node.right;
            node.right = null;
            invert(node.left);
        } else return;
    }
}
