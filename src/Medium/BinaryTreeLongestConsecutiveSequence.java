package Medium;

public class BinaryTreeLongestConsecutiveSequence {
    public int longestConsecutive(TreeNode root) {
        return dfs(1,root);
    }

    private int dfs(int prevCount, TreeNode node){
        int currentCount = prevCount;
        if(node.left != null){
            currentCount = Math.max(dfs(node.val+1 == node.left.val? prevCount+1:1,node.left),currentCount);
        }
        if(node.right != null){
            currentCount = Math.max(dfs(node.val+1 == node.right.val? prevCount+1:1,node.right),currentCount);
        }
        return currentCount;
    }
}
