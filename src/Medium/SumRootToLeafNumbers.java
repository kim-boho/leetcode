package Medium;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        return addPath(root, sum);
    }

    private int addPath(TreeNode node, int sum){
        if(node == null) return 0;

        sum = (sum*10);
        sum += node.val;

        if(node.left == null && node.right == null) return sum;

        return addPath(node.left, sum) + addPath(node.right, sum);

    }
}
