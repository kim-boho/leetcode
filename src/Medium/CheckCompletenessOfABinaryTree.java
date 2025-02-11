package Medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class CheckCompletenessOfABinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                TreeNode n = q.poll();
                if(n.left == null){
                    if(n.right != null) return false;
                    else{
                        while(!q.isEmpty()){
                            TreeNode temp = q.poll();
                            if(temp.left != null || temp.right != null) return false;
                        }
                        return true;
                    }
                } else q.add(n.left);
                if(n.right == null){
                    while(!q.isEmpty()){
                        TreeNode temp = q.poll();
                        if(temp.left != null || temp.right != null) return false;
                    }
                    return true;
                } else q.add(n.right);
                size--;
            }
        }
        return false;
    }
}
