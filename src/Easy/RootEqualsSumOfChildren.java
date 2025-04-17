package Easy;

import Medium.TreeNode;

public class RootEqualsSumOfChildren {
    public boolean checkTree(TreeNode root) {
        int sum = root.left != null? root.left.val:0;
        sum += (root.right != null? root.right.val:0);
        return sum == root.val;
    }
}
