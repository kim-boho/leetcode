package Medium;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class PathSum3 {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        HashMap<TreeNode, TreeNode> nodesWithParents = new HashMap<>();
        nodesWithParents.put(root,null);

        while(q.size() > 0){
            TreeNode temp = q.poll();
            if(temp.left != null){
                nodesWithParents.put(temp.left, temp);
                q.add(temp.left);
            }
            if(temp.right != null){
                nodesWithParents.put(temp.right, temp);
                q.add(temp.right);
            }
        }

        long total = 0;
        Iterator it = nodesWithParents.keySet().iterator();
        while(it.hasNext()){
            TreeNode start = (TreeNode) it.next();
            long tempSum = 0;
            while(start != null){
                tempSum += start.val;
                if(tempSum == targetSum) total++;
                start = nodesWithParents.get(start);
            }
        }

        return (int) total;
    }
}
