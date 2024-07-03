package Easy;

import Medium.TreeNode;

public class BalancedBinaryTree {
    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        int h = recursion(root);
        return ans;
    }

    private int recursion(TreeNode t){
        if(t == null) return 0;
        if(t.left == null && t.right == null) return 1;
        int l = recursion(t.left);
        int r = recursion(t.right);
        if(Math.abs(l-r) > 1){
            ans = false;
        }
        return Math.max(l,r)+1;
    }
}
