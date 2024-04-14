package Medium;

public class InsufficientNodesInRootToLeafPaths {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return helper(root,limit,0)? root:null;
    }

    private boolean helper(TreeNode node, int limit, int sum){
        if(node.left == null && node.right == null){
            return sum+node.val >= limit;
        }
        boolean leftNodeAlive = false;
        boolean rightNodeAlive = false;
        if(node.left != null){
            leftNodeAlive = helper(node.left, limit, sum+node.val);
            if(!leftNodeAlive) node.left = null;
        }
        if(node.right != null){
            rightNodeAlive = helper(node.right, limit, sum+node.val);
            if(!rightNodeAlive) node.right = null;
        }
        return leftNodeAlive || rightNodeAlive;
    }
}
