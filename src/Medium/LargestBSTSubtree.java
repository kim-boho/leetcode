package Medium;

public class LargestBSTSubtree {
    int numOfLargestSubtree = 1;
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        int[] rootSubtree = trackMinAndMax(root);
        return numOfLargestSubtree;
    }

    private int[] trackMinAndMax(TreeNode node){
        if(node == null) return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE,0};
        if(node.left == null && node.right == null) return new int[]{node.val,node.val,1};
        int[] ans ={node.val, node.val,1};
        int[] leftNodeNum = trackMinAndMax(node.left);
        int[] rightNodeNum = trackMinAndMax(node.right);
        if(leftNodeNum[2] == -1 || rightNodeNum[2] == -1 || node.val <= leftNodeNum[1] || node.val >= rightNodeNum[0]){
            ans[2] = -1;
            return ans;
        }
        ans[0] = Math.min(leftNodeNum[0],ans[0]);
        ans[2] += leftNodeNum[2];
        ans[1] = Math.max(rightNodeNum[1],ans[1]);
        ans[2] += rightNodeNum[2];
        numOfLargestSubtree = Math.max(numOfLargestSubtree,ans[2]);
        return ans;
    }
}
