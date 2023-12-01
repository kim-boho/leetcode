package Easy;
import Medium.TreeNode;

import java.util.ArrayList;
import java.util.List;
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList();
        preorder(ans, root);
        return ans;
    }

    private void preorder(List<Integer> ans, TreeNode node){
        if(node == null) return;
        ans.add(node.val);
        if(node.left != null) preorder(ans, node.left);
        if(node.right != null) preorder(ans, node.right);
    }
}
