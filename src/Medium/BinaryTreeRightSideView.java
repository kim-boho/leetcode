package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        q.add(root);
        ans.add(root.val);
        while(q.size()>0){
            Queue<TreeNode> temp = new LinkedList<>();
            int leftVal = -1;
            while(q.size() != 0){
                TreeNode node = q.poll();
                if(node.left != null){
                    temp.add(node.left);
                    leftVal = node.left.val;
                }
                if(node.right != null){
                    temp.add(node.right);
                    leftVal = node.right.val;
                }
            }
            if(leftVal != -1) ans.add(leftVal);
            q = temp;
        }

        return ans;
    }
}
