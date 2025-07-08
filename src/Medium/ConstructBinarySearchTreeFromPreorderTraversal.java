package Medium;

import java.util.Stack;

public class ConstructBinarySearchTreeFromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode head = new TreeNode(preorder[0]);
        Stack<TreeNode> st = new Stack<>();
        st.add(head);
        int i = 1;
        while(i < preorder.length){
            TreeNode top = st.peek();
            int n = preorder[i++];
            TreeNode curr = new TreeNode(n);
            if(top.val > n) top.left = curr;
            else{
                top = st.pop();
                while(!st.isEmpty() && st.peek().val < n) top = st.pop();
                top.right = curr;
            }
            st.add(curr);
        }
        return head;
    }
}
