package Easy;

import Medium.TreeNode;

public class MinimumAbsoluteDifferenceInBst {
    public int getMinimumDifference(TreeNode root) {
        Integer[] ans = new Integer[1];
        Integer[] prev = new Integer[1];
        inorder(root, ans, prev);
        return ans[0];
    }

    private void inorder(TreeNode node, Integer[] ans, Integer[] prev){
        if(node.left != null) inorder(node.left, ans, prev);
        if(prev[0] == null) prev[0] = node.val;
        else{
            if(ans[0] == null) ans[0] = Math.abs(prev[0]-node.val);
            else{
                if(Math.abs(prev[0]-node.val) < ans[0]) ans[0] = Math.abs(prev[0]-node.val);
            }
            prev[0] = node.val;
        }
        if(node.right != null) inorder(node.right, ans, prev);
    }
}
