package Medium;

import java.util.ArrayList;
import java.util.List;

public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        TreeNode[] parents = new TreeNode[501];
        boolean[] check = new boolean[501];
        List<Integer> ans = new ArrayList<>();
        setHead(null, root, parents);
        getDist(0,target,ans,k,parents,check);
        return ans;
    }

    private void setHead(TreeNode par, TreeNode node, TreeNode[] parents){
        parents[node.val] = par;
        if(node.left != null) setHead(node, node.left, parents);
        if(node.right != null) setHead(node, node.right, parents);
    }

    private void getDist(int d, TreeNode node, List<Integer> ans, int k, TreeNode[] parents, boolean[] check){
        check[node.val] = true;
        if(d == k){
            ans.add(node.val);
            return;
        }
        if(parents[node.val] != null && !check[parents[node.val].val]){
            getDist(d+1,parents[node.val],ans,k,parents,check);
        }
        if(node.left != null && !check[node.left.val]){
            getDist(d+1,node.left,ans,k,parents,check);
        }
        if(node.right != null && !check[node.right.val]){
            getDist(d+1,node.right,ans,k,parents,check);
        }
    }
}
