package Easy;

import Medium.TreeNode;

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) return root2;
        else if(root2 == null) return root1;
        dfs(root1,root2);
        return root1;
    }

    private void dfs(TreeNode n1, TreeNode n2){
        n1.val += n2.val;
        if(n1.left != null && n2.left != null) dfs(n1.left, n2.left);
        else if(n1.left == null && n2.left != null){
            n1.left = n2.left;
            n2.left = null;
        }
        if(n1.right != null && n2.right != null) dfs(n1.right, n2.right);
        else if(n1.right == null && n2.right != null){
            n1.right = n2.right;
            n2.right = null;
        }
    }
}
