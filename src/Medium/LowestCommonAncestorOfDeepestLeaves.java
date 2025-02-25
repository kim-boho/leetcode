package Medium;

import java.util.HashSet;

public class LowestCommonAncestorOfDeepestLeaves {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null) return null;
        int leftDep = findMaxDep(root.left);
        int rightDep = findMaxDep(root.right);
        if(leftDep == rightDep) return root;
        else if(leftDep > rightDep) return lcaDeepestLeaves(root.left);
        else return lcaDeepestLeaves(root.right);
    }

    private int findMaxDep(TreeNode node){
        if(node == null) return 0;
        return Math.max(findMaxDep(node.left)+1,findMaxDep(node.right)+1);
    }
}
