package Medium;

public class KthSmallestElementInABst {
    int ans = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorderT(root, k);
        return ans;
    }

    private void inorderT(TreeNode node, int k){
        if(node.left != null) inorderT(node.left, k);
        count++;
        if(count == k){
            ans = node.val;
            return;
        }
        if(node.right != null) inorderT(node.right, k);
    }
}
