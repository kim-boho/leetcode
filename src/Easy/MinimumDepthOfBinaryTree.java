package Easy;

import Medium.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ans = 1;
        while(q.size()>0){
            Queue<TreeNode> temp = new LinkedList<>();
            while(q.size()>0){
                TreeNode n = q.poll();
                if(n.left == null && n.right == null) return ans;
                if(n.left != null) temp.add(n.left);
                if(n.right != null) temp.add(n.right);
            }
            q = temp;
            ans++;
        }
        return -1;
    }
}
