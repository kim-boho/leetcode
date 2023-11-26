package Easy;

import Medium.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(q.size() > 0){
            Queue<TreeNode> temp = new LinkedList();
            double sum = 0;
            int count = 0;
            while(q.size() > 0){
                TreeNode n = q.poll();
                sum += (double) n.val;
                count++;
                if(n.left != null) temp.add(n.left);
                if(n.right != null) temp.add(n.right);
            }
            ans.add((sum/(double)count));
            q = temp;
        }
        return ans;
    }
}
