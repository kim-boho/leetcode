package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> st = new LinkedList<>();
        st.add(root);
        int count = 1;
        int childCount = 0;
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        while(st.size() > 0){
            List<Integer> li = new ArrayList<>();
            while(count > 0){
                TreeNode temp = st.poll();
                li.add(temp.val);
                if(temp.left != null){
                    st.add(temp.left);
                    childCount++;
                }
                if(temp.right != null){
                    st.add(temp.right);
                    childCount++;
                }
                count--;
            }
            ans.add(li);
            count = childCount;
            childCount = 0;
        }

        return ans;
    }
}
