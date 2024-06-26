package Medium;

import java.util.ArrayList;

public class BalanceABinarySearchTree {
    ArrayList<Integer> li = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return makeTree(li,0,li.size());
    }

    private void inorder(TreeNode t){
        if(t == null) return;
        inorder(t.left);
        li.add(t.val);
        inorder(t.right);
    }

    private TreeNode makeTree(ArrayList<Integer> li, int start, int end){
        int mid = (end+start)/2;
        TreeNode t = new TreeNode(li.get(mid));
        if(end - start == 2){
            t.left = new TreeNode(li.get(mid-1));
        } else if(end - start == 3){
            t.left = new TreeNode(li.get(mid-1));
            t.right = new TreeNode(li.get(mid+1));
        } else if(end - start > 3){
            t.left = makeTree(li,start,mid);
            t.right = makeTree(li,mid+1,end);
        }
        return t;
    }
}
