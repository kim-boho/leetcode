package Medium;

public class SumOfNodesWithEvenValuedGrandparent {
    int ans = 0;
    public int sumEvenGrandparent(TreeNode root) {
        dfs(0,0,root);
        return ans;
    }

    private void dfs(int p, int gp, TreeNode t) {
        if(gp > 0 && gp % 2 == 0) ans += t.val;

        if(t.left != null) dfs(t.val, p, t.left);
        if(t.right != null) dfs(t.val, p, t.right);
    }
}
