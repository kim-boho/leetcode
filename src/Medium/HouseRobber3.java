package Medium;

public class HouseRobber3 {
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0],result[1]);
    }

    private int[] dfs(TreeNode node){
        int[] result = new int[]{0,0};
        if(node == null){
            return result;
        }
        int[] fromLeft = dfs(node.left);
        int[] fromRight = dfs(node.right);
        result[0] = node.val + fromLeft[1] + fromRight[1];
        result[1] = Math.max(fromLeft[0],fromLeft[1])+Math.max(fromRight[0],fromRight[1]);
        return result;
    }
}
