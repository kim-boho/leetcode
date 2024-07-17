package Medium;

import java.util.ArrayList;
import java.util.List;

public class DeleteNodesAndReturnForest {
    boolean[] check = new boolean[1001];
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        for(int i:to_delete) check[i] = true;
        recursion(ans,root,true);
        return ans;
    }

    private void recursion(List<TreeNode> ans, TreeNode t, boolean isHead){
        if(t == null) return;
        if(isHead){
            if(check[t.val]){
                TreeNode temp = t.left;
                TreeNode temp2 = t.right;
                t.left = null;
                t.right = null;
                recursion(ans,temp,true);
                recursion(ans,temp2,true);
                return;
            } else{
                ans.add(t);
            }
        }

        if(t.left != null){
            if(check[t.left.val]){
                TreeNode temp = t.left;
                t.left = null;
                recursion(ans,temp.left,true);
                recursion(ans,temp.right,true);
            } else{
                recursion(ans,t.left,false);
            }
        }

        if(t.right != null){
            if(check[t.right.val]){
                TreeNode temp = t.right;
                t.right = null;
                System.out.println(temp.val);
                recursion(ans,temp.left,true);
                recursion(ans,temp.right,true);
            } else{
                recursion(ans,t.right,false);
            }
        }
    }
}
