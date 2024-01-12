package Medium;

public class MaximumDifferenceBetweenNodeAndAncestor {
    public int maxAncestorDiff(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = -1;
        if(root.left != null) helper(root.val, root.val, root.left, ans);
        if(root.right != null) helper(root.val, root.val, root.right, ans);

        return ans[0];
    }

    private void helper(int min, int max, TreeNode node, int[] ans){
        int val = node.val;
        if(Math.abs(min-val) > ans[0]) ans[0] = Math.abs(min-val);
        if(Math.abs(max-val) > ans[0]) ans[0] = Math.abs(max-val);

        if(val < min && val < max) min = val;
        else if(val > min && val > max) max = val;

        if(node.left != null) helper(min, max, node.left, ans);
        if(node.right != null) helper(min, max, node.right, ans);
    }
}
