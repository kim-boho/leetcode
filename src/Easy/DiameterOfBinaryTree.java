package Easy;

import Medium.TreeNode;

public class DiameterOfBinaryTree {
    int ans = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans-1;
    }

    private int dfs(TreeNode node){
        if(node.left == null && node.right == null) return 1;
        else if(node.left != null && node.right == null){
            int temp = dfs(node.left);
            ans = Math.max(ans, temp+1);
            return 1+temp;
        } else if(node.right != null && node.left == null){
            int temp = dfs(node.right);
            ans = Math.max(ans, temp+1);
            return 1+temp;
        } else{
            int leftSum = dfs(node.left);
            int rightSum = dfs(node.right);
            ans = Math.max(ans, leftSum+rightSum+1);
            return Math.max(leftSum+1, rightSum+1);
        }
    }
}
