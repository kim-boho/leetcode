package Easy;

import Medium.TreeNode;

public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int ans = 0;
        if(root.val >= low && root.val <= high) ans += root.val;
        if(root.left != null) ans += rangeSumBST(root.left, low, high);
        if(root.right != null) ans += rangeSumBST(root.right, low, high);
        return ans;
    }
}
