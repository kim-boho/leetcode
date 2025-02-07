package Easy;

import Medium.TreeNode;

public class CousinsInBinaryTree {
    int dX = -1;
    int dY = -2;
    int xPar = -1;
    int yPar = -2;
    int x;
    int y;
    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        recursion(root,1,-1);
        return dX == dY && xPar != yPar;
    }

    private void recursion(TreeNode node, int depth, int par){
        if(node == null) return;
        if(node.val == x){
            dX = depth;
            xPar = par;
        } else if(node.val == y){
            dY = depth;
            yPar = par;
        }
        if(dX != -1 && dY != -2) return;
        recursion(node.left,depth+1,node.val);
        recursion(node.right,depth+1,node.val);
    }
}
