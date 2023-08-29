package Medium;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return recursion(null, nums, 0, nums.length-1, null, false, false);
    }

    private TreeNode recursion(TreeNode head, int[] nums, int start, int end, TreeNode tn, boolean isLeft, boolean isRight){
        int maxIdx = -1;
        int max = -1;

        for(int i=start; i<=end; i++){
            if(nums[i] > max){
                maxIdx = i;
                max = nums[i];
            }
        }

        TreeNode maxTn = new TreeNode(max);
        if(tn == null){
            head = maxTn;
        } else{
            if(isLeft) tn.left = maxTn;
            else if(isRight) tn.right = maxTn;
        }

        if(maxIdx-1 >= start) recursion(head, nums, start, maxIdx-1, maxTn, true, false);
        if(maxIdx+1 <= end) recursion(head, nums, maxIdx+1, end, maxTn, false, true);

        return head;
    }
}
