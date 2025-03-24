package Medium;

public class CountNodesEqualToSumOfDescendants {
    int ans = 0;
    public int equalToDescendants(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node){
        if(node == null) return 0;
        int sum = dfs(node.left)+dfs(node.right);
        if(node.val == sum) ans++;
        return sum+node.val;
    }
}
