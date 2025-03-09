package Medium;

public class CountUnivalueSubtrees {
    int ans = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        int dummy = checkUnival(root);
        return ans;
    }

    private int checkUnival(TreeNode node){
        if(node.left == null && node.right == null){
            ans++;
            return node.val;
        }
        if(node.left == null){
            int val = checkUnival(node.right);
            if(val == node.val){
                ans++;
                return node.val;
            } else return 1001;
        } else if(node.right == null){
            int val = checkUnival(node.left);
            if(val == node.val){
                ans++;
                return node.val;
            } else return 1001;
        } else{
            int val1 = checkUnival(node.left);
            int val2 = checkUnival(node.right);
            if(val1 == val2 && node.val == val1){
                ans++;
                return node.val;
            } else return 1001;
        }
    }
}
