package Medium;

public class TrimABinarySearchTree {
    public TreeNode trimBST(TreeNode node, int low, int high) {
        if(node == null) return null;
        TreeNode left = trimBST(node.left,low,high);
        TreeNode right = trimBST(node.right,low,high);
        node.left = null;
        node.right = null;
        if(node.val < low){
            return right;
        } else if(node.val > high){
            return left;
        } else{
            node.left = left;
            node.right = right;
            return node;
        }
    }
}
