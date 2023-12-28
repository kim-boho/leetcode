package Easy;

import Medium.TreeNode;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root.val == subRoot.val){
            if(helper(root, subRoot)) return true;
        }
        if(root.left != null){
            if(isSubtree(root.left, subRoot)) return true;
        }
        if(root.right != null){
            if(isSubtree(root.right, subRoot)) return true;
        }
        return false;
    }

    private boolean helper(TreeNode root1, TreeNode root2){
        if(root1.val != root2.val) return false;
        if(root1.left == null && root1.right == null && root2.left == null && root2.right ==null) return true;
        if((root1.left == null && root2.left != null) || (root2.left == null && root1.left != null)
                || (root1.right == null && root2.right != null) || (root2.right == null && root1.right != null)) return false;

        if(root1.left != null && root2.left != null){
            if(!helper(root1.left, root2.left)) return false;
        }
        if(root1.right != null && root2.right != null){
            if(!helper(root1.right, root2.right)) return false;
        }
        return true;
    }
}
