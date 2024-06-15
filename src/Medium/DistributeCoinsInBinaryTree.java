package Medium;

public class DistributeCoinsInBinaryTree {
    int ans = 0;
    public int distributeCoins(TreeNode root) {
        int num = helper(root);
        return ans;
    }

    private int helper(TreeNode t){
        if(t.left == null && t.right == null){
            ans += Math.abs(t.val-1);
            return t.val-1;
        }
        int fromLeft = t.left != null ? helper(t.left):0;
        int fromRight = t.right != null ? helper(t.right):0;
        int sum = t.val+fromLeft+fromRight-1;
        ans += Math.abs(sum);
        return sum;
    }
}
