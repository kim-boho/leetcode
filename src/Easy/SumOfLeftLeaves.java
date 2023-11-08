package Easy;

import Medium.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int ans = 0;
        while(q.size() > 0){
            TreeNode tn = q.poll();
            if(tn.left != null){
                if(tn.left.left == null && tn.left.right == null) ans += tn.left.val;
                q.add(tn.left);
            }
            if(tn.right != null){
                q.add(tn.right);
            }
        }
        return ans;
    }
}
