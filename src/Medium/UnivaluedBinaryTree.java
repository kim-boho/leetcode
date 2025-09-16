package Medium;

public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if(root.left != null){
            if(root.val != root.left.val) return false;
            if(!isUnivalTree(root.left)) return false;
        }
        if(root.right != null){
            if(root.val != root.right.val) return false;
            if(!isUnivalTree(root.right)) return false;
        }
        return true;
    }
}
