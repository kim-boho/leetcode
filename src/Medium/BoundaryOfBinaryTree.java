package Medium;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        ans.add(root.val);
        if(root.left == null && root.right == null) return ans;
        TreeNode node = root.left;
        while(node != null){
            if(node.left == null && node.right == null) break;
            ans.add(node.val);
            if(node.left != null) node = node.left;
            else node = node.right;
        }
        addLeaves(root, ans);
        List<Integer> rights = new ArrayList<>();
        node = root.right;
        while(node != null){
            if(node.left == null && node.right == null) break;
            rights.add(node.val);
            if(node.right != null) node = node.right;
            else node = node.left;
        }
        for(int i=rights.size()-1; i>=0; i--) ans.add(rights.get(i));
        return ans;
    }

    private void addLeaves(TreeNode node, List<Integer> ans){
        if(node == null) return;
        if(node.left == null && node.right == null){
            ans.add(node.val);
            return;
        }
        addLeaves(node.left,ans);
        addLeaves(node.right,ans);
    }
}
