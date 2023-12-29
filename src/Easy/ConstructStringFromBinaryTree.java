package Easy;

import Medium.TreeNode;

public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        helper(root, ans);
        return ans.substring(1,ans.length()-1);
    }

    private void helper(TreeNode root, StringBuilder ans){
        ans.append("(").append(root.val);
        if(root.left != null) helper(root.left, ans);
        else{
            if(root.right != null) ans.append("()");
        }
        if(root.right != null) helper(root.right, ans);
        ans.append(")");
    }
}
