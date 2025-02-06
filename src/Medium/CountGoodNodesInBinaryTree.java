package Medium;

public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return countGoodNodes(-10001,root);
    }

    private int countGoodNodes(int max, TreeNode root){
        if(root == null) return 0;
        int ans = max <= root.val? 1:0;
        max = Math.max(root.val,max);
        ans += countGoodNodes(max,root.left);
        ans += countGoodNodes(max,root.right);
        return ans;
    }
}
