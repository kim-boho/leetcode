package Easy;

import Medium.TreeNode;

public class SecondMinimumNodeInABinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;

        int[] mins = new int[2];
        mins[0] = root.val;
        mins[1] = -1;

        helper(root, mins);

        return mins[1];
    }

    private void helper(TreeNode node, int[] mins){
        int val = node.val;
        if(mins[0] > val){
            mins[1] = mins[0];
            mins[0] = val;
        } else if((mins[1] == -1 && mins[0] < val) || (mins[0] < val && mins[1] > val)) mins[1] = val;
        if(node.left != null) helper(node.left, mins);
        if(node.right != null) helper(node.right, mins);
    }
}
