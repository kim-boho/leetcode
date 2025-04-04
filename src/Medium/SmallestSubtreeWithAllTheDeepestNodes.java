package Medium;

public class SmallestSubtreeWithAllTheDeepestNodes {
    int maxDep;
    TreeNode ans;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        helper(root,0);
        return ans;
    }

    private int helper(TreeNode node, int h){
        int l = node.left==null? h:helper(node.left,h+1);
        int r = node.right==null? h:helper(node.right,h+1);
        int dep =  Math.max(l,r);
        if(dep >= maxDep && l == r){
            ans = node;
            maxDep = dep;
        }
        return dep;
    }
}
