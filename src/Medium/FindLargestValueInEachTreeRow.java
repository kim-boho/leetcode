package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList();
        Queue<TreeNode> q = new LinkedList();
        if(root == null) return ans;
        ans.add(root.val);
        q.add(root);
        while(q.size() > 0){
            Queue<TreeNode> temp = new LinkedList();
            int max = Integer.MIN_VALUE;
            boolean isEnd = true;
            while(q.size() > 0){
                TreeNode t = q.poll();
                if(t.left != null){
                    if(max < t.left.val) max = t.left.val;
                    temp.add(t.left);
                    isEnd = false;
                }
                if(t.right != null){
                    if(max < t.right.val) max = t.right.val;
                    temp.add(t.right);
                    isEnd = false;
                }
            }
            if(!isEnd) ans.add(max);
            q = temp;
        }
        return ans;
    }
}
