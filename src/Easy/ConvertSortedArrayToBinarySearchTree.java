package Easy;

import Medium.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return recursion(nums, 0, nums.length-1);
    }

    private TreeNode recursion(int[] nums, int start, int end){
        if(start>end) return null;
        else if(start == end) return new TreeNode(nums[start]);

        int mid = (start+end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = recursion(nums, start, mid-1);
        node.right = recursion(nums, mid+1, end);
        return node;
    }
}
