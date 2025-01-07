package Easy;

import Medium.TreeNode;

public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode ans = root;
        while(ans != null){
            if(ans.val < val){
                ans = ans.right;
            } else if(ans.val > val){
                ans = ans.left;
            } else break;
        }
        return ans;
    }
}
