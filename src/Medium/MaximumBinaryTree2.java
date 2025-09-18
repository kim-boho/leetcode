package Medium;

public class MaximumBinaryTree2 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        if(root.val < val){
            TreeNode newHead = new TreeNode(val);
            newHead.left = root;
            return newHead;
        } else{
            root.right = insertIntoMaxTree(root.right,val);
            return root;
        }
    }
}
