package Easy;

import Medium.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;

public class FindModeInBinarySearchTree {
    int max = 0;
    public int[] findMode(TreeNode root) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        helper(root, hm);
        ArrayList<Integer> li = new ArrayList<>();
        for(Integer i:hm.keySet()){
            if(hm.get(i) == max) li.add(i);
        }
        int[] ans = new int[li.size()];
        for(int i=0; i<ans.length; i++){
            ans[i] = li.get(i);
        }
        return ans;
    }

    private void helper(TreeNode node,HashMap<Integer,Integer> hm){
        if(node == null) return;
        hm.put(node.val, hm.getOrDefault(node.val,0)+1);
        if(max < hm.get(node.val)) max = hm.get(node.val);
        helper(node.left, hm);
        helper(node.right, hm);
    }
}
