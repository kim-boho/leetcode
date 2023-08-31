package Medium;

import java.util.ArrayList;

public class BinarySearchTreeIterator {
    class BSTIterator {
        ArrayList<TreeNode> inorder;
        int pointer;
        public BSTIterator(TreeNode root) {
            inorder = new ArrayList<>();
            inorderTra(root);
            pointer = 0;
        }

        public int next() {
            return inorder.get(pointer++).val;
        }

        public boolean hasNext() {
            return pointer < inorder.size() ? true:false;
        }

        private void inorderTra(TreeNode root){
            if(root == null) return;
            inorderTra(root.left);
            inorder.add(root);
            inorderTra(root.right);
        }
    }
}
