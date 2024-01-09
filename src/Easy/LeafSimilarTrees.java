package Easy;

import Medium.TreeNode;

import java.util.ArrayList;

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> li1 = new ArrayList<Integer>();
        ArrayList<Integer> li2 = new ArrayList<Integer>();
        recursion(root1, li1);
        recursion(root2, li2);
        if(li1.size() != li2.size()) return false;
        for(int i=0; i<li1.size(); i++){
            if(li1.get(i) != li2.get(i)) return false;
        }
        return true;
    }

    private void recursion(TreeNode node, ArrayList<Integer> li){
        if(node.left == null && node.right == null) li.add(node.val);
        else{
            if(node.left != null) recursion(node.left, li);
            if(node.right != null) recursion(node.right, li);
        }
    }
}
