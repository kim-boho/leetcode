package Easy;

import Medium.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList();
        List<String> nodes = new ArrayList();
        helper(root, nodes, ans);
        return ans;
    }

    private void helper(TreeNode node, List<String> nodes, List<String> ans){
        if(node.left == null && node.right == null){
            nodes.add(String.valueOf(node.val));
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<nodes.size(); i++){
                sb.append(nodes.get(i));
                if(i != nodes.size()-1) sb.append("->");
            }
            ans.add(sb.toString());
            nodes.remove(nodes.size()-1);
        } else{
            nodes.add(String.valueOf(node.val));
            if(node.left != null) helper(node.left, nodes, ans);
            if(node.right != null) helper(node.right, nodes, ans);
            nodes.remove(nodes.size()-1);
        }
    }
}
