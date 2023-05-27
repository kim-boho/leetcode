package Hard;

import Medium.TreeNode;

import java.util.ArrayList;
import java.util.Collections;

public class BinaryTreeMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int endInteger = maxPathSum2(root);
        return maxSum;
    }
    private int maxPathSum2(TreeNode root) {
        if(root.left != null && root.right != null){
            int leftSum = maxPathSum2(root.left);
            int rightSum = maxPathSum2(root.right);
            ArrayList<Integer> tempLi = new ArrayList<>();
            tempLi.add(root.val);
            tempLi.add(root.val + leftSum);
            tempLi.add(root.val + rightSum);
            tempLi.add(root.val + leftSum + rightSum);
            maxSum = Math.max(Collections.max(tempLi), maxSum);

            tempLi.remove(tempLi.size()-1);

            return Collections.max(tempLi);
        } else if(root.left == null && root.right != null){
            int rightSum = maxPathSum2(root.right);
            maxSum = Math.max(root.val, Math.max(maxSum, Math.max(rightSum, rightSum+root.val)));
            return Math.max(root.val+rightSum, root.val);
        } else if(root.left != null && root.right == null){
            int leftSum = maxPathSum2(root.left);
            maxSum = Math.max(root.val, Math.max(maxSum, Math.max(leftSum, leftSum+root.val)));
            return Math.max(root.val+leftSum, root.val);
        } else{
            maxSum = Math.max(maxSum, root.val);
            return root.val;
        }
    }
}
