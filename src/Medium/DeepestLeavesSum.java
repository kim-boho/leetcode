package Medium;

public class DeepestLeavesSum {
    int max = 0;
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        dfs(root,0);
        return sum;
    }

    private void dfs(TreeNode t, int depth){
        if(t.left == null && t.right == null){
            if(max < depth){
                max = depth;
                sum = t.val;
            } else if(max == depth) sum += t.val;
            return;
        }
        if(t.left != null) dfs(t.left,depth+1);
        if(t.right != null) dfs(t.right,depth+1);

    }
}
