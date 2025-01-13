package Medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        Deque<Integer> nums = new ArrayDeque<>();
        q.add(root);
        nums.add(1);
        int ans = 1;
        while(!q.isEmpty()){
            ans = Math.max(ans,nums.peekLast()-nums.peekFirst()+1);
            Deque<TreeNode> tempQ = new ArrayDeque<>();
            Deque<Integer> tempNums = new ArrayDeque<>();
            while(!q.isEmpty()){
                TreeNode node = q.poll();
                int num = nums.poll();
                if(node.left != null){
                    tempQ.add(node.left);
                    tempNums.add(num*2-1);
                }
                if(node.right != null){
                    tempQ.add(node.right);
                    tempNums.add(num*2);
                }
            }
            q = tempQ;
            nums = tempNums;
        }
        return ans;
    }
}
