package Easy;

import Medium.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class TwoSum4InputIsABST {
    public boolean findTarget(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<Integer> hs = new HashSet<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode t = q.poll();
            if(hs.contains(k-t.val)) return true;
            hs.add(t.val);
            if(t.left != null) q.add(t.left);
            if(t.right != null) q.add(t.right);
        }
        return false;
    }
}
