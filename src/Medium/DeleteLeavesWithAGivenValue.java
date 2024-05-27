package Medium;

public class DeleteLeavesWithAGivenValue {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode dummyHead = new TreeNode();
        dummyHead.left = root;
        removeLeafNodesRecursive(root, dummyHead, target, true);
        return dummyHead.left;
    }

    private void removeLeafNodesRecursive(TreeNode t, TreeNode p, int target, boolean isLeft){
        if(t.left != null) removeLeafNodesRecursive(t.left, t, target, true);
        if(t.right != null) removeLeafNodesRecursive(t.right, t, target, false);
        if(t.left == null && t.right == null){
            if(isLeft && t.val == target) p.left = null;
            else if(!isLeft && t.val == target) p.right = null;
        }
    }
}
