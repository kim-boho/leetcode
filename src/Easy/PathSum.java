package Easy;

import Medium.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return addChild(root, targetSum, 0);
    }

    private boolean addChild(TreeNode node, int targetSum, int sum){
        sum += node.val;
        if(node.left == null && node.right == null){
            if(sum == targetSum) return true;
            else return false;
        } else if(node.left == null){
            return addChild(node.right, targetSum, sum);
        } else if(node.right == null){
            return addChild(node.left, targetSum, sum);
        } else{
            return addChild(node.left, targetSum, sum) || addChild(node.right, targetSum, sum);
        }
    }
}
