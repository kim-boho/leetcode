package Easy;

import Medium.TreeNode;

public class MinimumDistanceBetweenBSTNodes {
    int ans = 200000;
    TreeNode t = new TreeNode(-200000);
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode n){
        if(n == null) return;
        dfs(n.left);
        ans = Math.min(ans, n.val-t.val);
        t = n;
        dfs(n.right);
    }
}
