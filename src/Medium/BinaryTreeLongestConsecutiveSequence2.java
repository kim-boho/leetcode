package Medium;

public class BinaryTreeLongestConsecutiveSequence2 {
    int ans = 1;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        int[] rootsPath = dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode node){
        if(node == null) return new int[]{0,0};
        int[] fromLeft = dfs(node.left);
        int[] fromRight = dfs(node.right);
        int goingUp = 0;
        if(node.left != null && node.left.val == node.val-1) goingUp = fromLeft[0];
        if(node.right != null && node.right.val == node.val-1) goingUp = Math.max(goingUp,fromRight[0]);
        int goingDown = 0;
        if(node.left != null && node.left.val == node.val+1) goingDown = fromLeft[1];
        if(node.right != null && node.right.val == node.val+1) goingDown = Math.max(goingDown,fromRight[1]);
        ans = Math.max(ans,Math.max(goingUp+1,goingDown+1));
        if(node.left != null && node.right != null){
            if(node.left.val+1 == node.val && node.val+1 == node.right.val){
                ans = Math.max(ans,fromLeft[0]+fromRight[1]+1);
            }
            if(node.left.val-1 == node.val && node.val-1 == node.right.val){
                ans = Math.max(ans,fromLeft[1]+fromRight[0]+1);
            }
        }
        return new int[]{goingUp+1,goingDown+1};
    }
}
