package Medium;

public class EqualTreePartition {
    int half;
    boolean ans = false;
    public boolean checkEqualTree(TreeNode root) {
        if(root == null) return false;
        int sum = treeNodeSum(root);
        if(sum%2 == 1 || sum%2 == -1) return false;
        half = sum/2;
        isHalf(root.left);
        isHalf(root.right);
        return ans;
    }

    private int isHalf(TreeNode node){
        if(node == null || ans) return 0;
        int sum = node.val;
        sum += isHalf(node.left);
        sum += isHalf(node.right);
        if(sum == half) ans = true;
        return sum;
    }

    private int treeNodeSum(TreeNode node){
        if(node == null) return 0;
        return node.val+treeNodeSum(node.left)+treeNodeSum(node.right);
    }
}
