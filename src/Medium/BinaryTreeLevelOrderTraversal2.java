package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(q.size()>0){
            ArrayList<Integer> sameLevel = new ArrayList();
            Queue<TreeNode> temp = new LinkedList();
            while(q.size()>0){
                TreeNode node = q.poll();
                sameLevel.add(node.val);
                if(node.left != null) temp.add(node.left);
                if(node.right != null) temp.add(node.right);
            }
            ans.add(0, sameLevel);
            q = temp;
        }
        return ans;
    }
}
