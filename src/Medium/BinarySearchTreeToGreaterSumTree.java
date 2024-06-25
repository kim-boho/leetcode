package Medium;

public class BinarySearchTreeToGreaterSumTree {
    int rightSum = 0;
    public TreeNode bstToGst(TreeNode root) {
        return addSums(root);
    }

    private TreeNode addSums(TreeNode t){
        TreeNode treeNodeWithSum = new TreeNode();
        if(t.right == null && t.left == null){
            rightSum += t.val;
            treeNodeWithSum.val = rightSum;
            return treeNodeWithSum;
        }

        if(t.right != null){
            treeNodeWithSum.right = addSums(t.right);
        }
        rightSum += t.val;
        treeNodeWithSum.val = rightSum;
        if(t.left != null){
            treeNodeWithSum.left = addSums(t.left);
        }
        return treeNodeWithSum;
    }
}
