package Medium;

public class LowestCommonAncestorOfaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode pointer = root;
        while(pointer != p && pointer != q){
            if((pointer.val > p.val && pointer.val < q.val) || (pointer.val < p.val && pointer.val > q.val)) return pointer;
            if(pointer.val > p.val && pointer.val > q.val) pointer = pointer.left;
            else if(pointer.val < p.val && pointer.val < q.val) pointer = pointer.right;
        }
        return pointer;
    }
}
