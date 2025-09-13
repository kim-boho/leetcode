package Medium;

public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        boolean dummy = hasOne(root);
        return dummy? root:null;
    }

    private boolean hasOne(TreeNode node){
        if(node == null) return false;

        boolean left = hasOne(node.left);
        boolean right = hasOne(node.right);

        if(node.val == 0){
            if(!left && !right) return false;
        }

        if(!left) node.left = null;
        if(!right) node.right = null;
        return true;
    }
}
