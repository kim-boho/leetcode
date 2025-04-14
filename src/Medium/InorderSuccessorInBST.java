package Medium;

public class InorderSuccessorInBST {
    boolean isNext = false;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return findSuccessor(root,p);
    }

    private TreeNode findSuccessor(TreeNode node, TreeNode p){
        if(node.left != null){
            TreeNode temp = findSuccessor(node.left,p);
            if(temp != null) return temp;
        }
        if(isNext) return node;
        if(node == p) isNext = true;
        if(node.right != null){
            TreeNode temp = findSuccessor(node.right,p);
            if(temp != null) return temp;
        }
        return null;
    }
}
