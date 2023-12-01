package Easy;

import Medium.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList();
        postorder(ans, root);
        return ans;
    }

    private void postorder(List<Integer> ans, TreeNode node){
        if(node == null) return;
        if(node.left != null) postorder(ans, node.left);
        if(node.right != null) postorder(ans, node.right);
        ans.add(node.val);
    }
}
