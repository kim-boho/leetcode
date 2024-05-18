package Easy;

import Medium.TreeNode;

public class EvaluateBooleanBinaryTree {
    public boolean evaluateTree(TreeNode root) {
        if(root.val < 2) return root.val == 1;
        else{
            if(root.val == 2){
                return evaluateTree(root.left) || evaluateTree(root.right);
            } else{
                return evaluateTree(root.left) && evaluateTree(root.right);
            }
        }
    }
}
