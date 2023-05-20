package Medium;

public class ValidateBinarySearchTree {
    long prev = Long.MIN_VALUE;
    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return false;
        TreeNode pointer = root;
        inorder(pointer);
        return isValid;
    }

    private void inorder(TreeNode node){
        if(node != null && isValid){
            if(node.left != null) inorder(node.left);
            if(node.val <= prev) isValid = false;
            else prev = (long) node.val;
            if(isValid && node.right != null) inorder(node.right);
        }
    }
}
