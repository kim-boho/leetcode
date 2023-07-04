package Medium;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean right = true;

        while(!q.isEmpty()){
            Stack<TreeNode> st = new Stack<>();
            List<Integer> tempLi = new ArrayList<>();
            while(q.size()>0){
                TreeNode tempTN = q.poll();
                tempLi.add(tempTN.val);
                if(right){
                    if(tempTN.right != null) st.add(tempTN.right);
                    if(tempTN.left != null) st.add(tempTN.left);
                } else{
                    if(tempTN.left != null) st.add(tempTN.left);
                    if(tempTN.right != null) st.add(tempTN.right);
                }
            }

            if(right) right = false;
            else right = true;

            Collections.reverse(tempLi);
            if(tempLi.size()>0) ans.add(tempLi);

            while(st.size()>0) q.add(st.pop());
        }
        return ans;
    }
}
