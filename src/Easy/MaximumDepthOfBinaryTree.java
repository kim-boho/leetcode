package Easy;

import Medium.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> st = new LinkedList<>();
        st.add(root);
        int ans = 0;
        int count = 1;
        while(st.size()>0){
            int childCount = 0;
            for(int i=0; i<count; i++){
                TreeNode pointer = st.poll();
                if(pointer.left != null){
                    childCount++;
                    st.add(pointer.left);
                }
                if(pointer.right != null){
                    childCount++;
                    st.add(pointer.right);
                }
            }
            ans++;
            if(childCount == 0) break;
            count = childCount;
        }
        return ans;
    }
}
