package Easy;

import Medium.TreeNode;

import java.util.ArrayList;

public class SumOfRootToLeafBinaryNumbers {
    int ans = 0;
    public int sumRootToLeaf(TreeNode root) {
        helper(new ArrayList<Integer>(),root);
        return ans;
    }

    private void helper(ArrayList<Integer> li, TreeNode node){
        if(node.left == null && node.right == null){
            li.add(node.val);
            int num=1;
            int sum=0;
            for(int i=li.size()-1; i >= 0; i--){
                sum += (num*li.get(i));
                num *= 2;
            }
            ans += sum;
            li.remove(li.size()-1);
            return;
        }
        li.add(node.val);
        if(node.left != null) helper(li,node.left);
        if(node.right != null) helper(li,node.right);
        li.remove(li.size()-1);
    }
}
