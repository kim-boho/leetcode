package Medium;

public class FlipEquivalentBinaryTrees {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        else if(root1 == null || root2 == null) return false;
        return checkNodes(root1,root2);
    }

    private boolean checkNodes(TreeNode n1, TreeNode n2){
        if(n1.val != n2.val) return false;
        TreeNode n1Left = n1.left;
        TreeNode n1Right = n1.right;
        int count1 = 0;
        if(n1.left != null) count1++;
        if(n1.right != null) count1++;

        TreeNode n2Left = n2.left;
        TreeNode n2Right = n2.right;
        int count2 = 0;
        if(n2.left != null) count2++;
        if(n2.right != null) count2++;

        if(count1 != count2) return false;
        else{
            if(count1 == 2){
                if(n1Left.val == n2Left.val){
                    return checkNodes(n1Left,n2Left) && checkNodes(n1Right,n2Right);
                } else {
                    return checkNodes(n1Left,n2Right) && checkNodes(n1Right,n2Left);
                }
            } else if(count1 == 1){
                TreeNode temp1 = n1Left;
                if(n1Left == null) temp1 = n1Right;
                TreeNode temp2 = n2Left;
                if(n2Left == null) temp2 = n2Right;
                return checkNodes(temp1,temp2);
            } else return true;
        }
    }
}
