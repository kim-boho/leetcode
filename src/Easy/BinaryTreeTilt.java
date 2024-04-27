package Easy;

import Medium.TreeNode;

public class BinaryTreeTilt {
    int ans = 0;
    public int findTilt(TreeNode root) {
        int sum = helper(root);
        return ans;
    }

    private int helper(TreeNode node){
        if(node == null) return 0;
        int leftSum = helper(node.left);
        int rightSum = helper(node.right);
        ans += Math.abs(leftSum-rightSum);
        return leftSum+rightSum+node.val;
    }
}
