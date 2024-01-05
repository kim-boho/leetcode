package Medium;

public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode t = new TreeNode(val);
        if(root == null) return t;
        TreeNode p = root;
        while(p != null){
            if(val < p.val){
                if(p.left == null){
                    p.left = t;
                    p = null;
                } else p = p.left;
            } else{
                if(p.right == null){
                    p.right = t;
                    p = null;
                } else p = p.right;
            }
        }
        return root;
    }
}
