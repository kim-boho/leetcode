package Medium;

public class PseudoPalindromicPathsInABinaryTree {
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] ans = new int[1];
        boolean[] isOdd = new boolean[10];
        dfs(root, ans, isOdd);
        return ans[0];
    }

    private void dfs(TreeNode node, int[] ans, boolean[] isOdd){
        isOdd[node.val] = !isOdd[node.val];
        if(node.left != null) dfs(node.left, ans, isOdd);
        if(node.right != null) dfs(node.right, ans, isOdd);
        if(node.left == null && node.right == null){
            int odd = 0;
            for(int i=1; i<10; i++){
                if(isOdd[i]) odd++;
            }
            if(odd < 2) ans[0]++;
        }
        isOdd[node.val] = !isOdd[node.val];
    }
}
