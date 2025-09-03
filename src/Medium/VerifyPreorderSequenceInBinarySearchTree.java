package Medium;

import java.util.Stack;

public class VerifyPreorderSequenceInBinarySearchTree {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> st = new Stack<>();
        int i=0;
        int bottomLimit = 0;
        while(i < preorder.length){
            while(i < preorder.length && (st.isEmpty() || st.peek() > preorder[i])){
                if(preorder[i] < bottomLimit) return false;
                st.add(preorder[i++]);
            }
            if(i == preorder.length) return true;
            while(!st.isEmpty() && st.peek() < preorder[i]){
                bottomLimit = st.pop();
            }
        }
        return true;
    }
}
