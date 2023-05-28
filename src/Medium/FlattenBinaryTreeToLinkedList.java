package Medium;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        TreeNode pointer = root;
        if(root == null) return;
        while(pointer != null){
            if(pointer.left != null && pointer.right != null){
                TreeNode temp = pointer.right;
                pointer.right = pointer.left;
                pointer.left = null;
                TreeNode rightiest = pointer.right;
                while(rightiest != null){
                    if(rightiest.right != null) rightiest = rightiest.right;
                    else break;
                }
                rightiest.right = temp;
                pointer = pointer.right;

            } else if(pointer.left != null && pointer.right == null){
                pointer.right = pointer.left;
                pointer.left = null;
                pointer = pointer.right;
            } else if(pointer.left == null && pointer.right != null){
                pointer = pointer.right;
            } else return;
        }
        return;

    }
}
