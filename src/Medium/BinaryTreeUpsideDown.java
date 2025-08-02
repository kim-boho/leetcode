package Medium;

public class BinaryTreeUpsideDown {
    TreeNode newHead = null;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) return root;
        makeUpsideDown(null,root);
        return newHead;
    }

    private void makeUpsideDown(TreeNode prevNode, TreeNode currentNode){
        if(currentNode.left != null) makeUpsideDown(currentNode,currentNode.left);
        if(newHead == null) newHead = currentNode;
        currentNode.right = prevNode;
        if(prevNode != null) prevNode.left = null;
        if(prevNode != null && prevNode.right != null){
            currentNode.left = prevNode.right;
            prevNode.right = null;
        }
    }
}
