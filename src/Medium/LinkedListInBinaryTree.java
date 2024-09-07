package Medium;

public class LinkedListInBinaryTree {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return checkTree(root,head);
    }

    private boolean checkTree(TreeNode tn, ListNode head){
        if(tn == null) return false;
        boolean temp = false;
        if(tn.val == head.val){
            temp = checkList(tn,head);
        }
        return temp || checkTree(tn.left,head) || checkTree(tn.right,head);
    }

    private boolean checkList(TreeNode tn, ListNode ln){
        if(tn == null && ln != null) return false;
        if(tn == null) return true;

        if(tn.val != ln.val) return false;
        if(ln.next == null) return true;

        return checkList(tn.left,ln.next) || checkList(tn.right,ln.next);
    }
}
