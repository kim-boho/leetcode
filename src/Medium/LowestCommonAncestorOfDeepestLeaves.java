package Medium;

import java.util.HashSet;

public class LowestCommonAncestorOfDeepestLeaves {
    int maxDep = 0;
    HashSet<TreeNode> commonAncs = new HashSet<>();
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null) return null;
        findMaxDep(0,root);
        if(maxDep == 0) return root;
        HashSet<TreeNode> curr = new HashSet<>();
        trackAncs(root,0,curr);
        TreeNode p = root;
        while(commonAncs.size()>1){
            commonAncs.remove(p);
            if(commonAncs.contains(p.left)) p = p.left;
            else p = p.right;

        }
        return p;
    }

    private void findMaxDep(int depth, TreeNode node){
        if(node.left == null && node.right == null){
            maxDep = Math.max(maxDep,depth);
            return;
        }
        if(node.left != null) findMaxDep(depth+1,node.left);
        if(node.right != null) findMaxDep(depth+1,node.right);
    }

    private void trackAncs(TreeNode node, int depth, HashSet<TreeNode> curr){
        curr.add(node);
        if(depth == maxDep){
            if(commonAncs.size() != 0){
                HashSet<TreeNode> temp = new HashSet<>();
                for(TreeNode tn:commonAncs){
                    if(!curr.contains(tn)){
                        temp.add(tn);
                    }
                }
                for(TreeNode tn:temp){
                    commonAncs.remove(tn);
                }
            } else{
                for(TreeNode tn:curr) commonAncs.add(tn);
            }
            curr.remove(node);
            return;
        }
        if(node.left != null) trackAncs(node.left,depth+1,curr);
        if(node.right != null) trackAncs(node.right,depth+1,curr);
        curr.remove(node);
    }
}
