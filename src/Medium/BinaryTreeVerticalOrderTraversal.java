package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        ArrayList<TreeNode> nodes = new ArrayList<>();
        ArrayList<Integer> posi = new ArrayList<>();
        nodes.add(root);
        posi.add(0);
        while(nodes.size() != 0){
            ArrayList<TreeNode> tempNodes = new ArrayList<>();
            ArrayList<Integer> tempPosi = new ArrayList<>();
            for(int i=0; i<nodes.size(); i++){
                TreeNode node = nodes.get(i);
                int val = node.val;
                int pos = posi.get(i);
                if(hm.containsKey(pos)) hm.get(pos).add(val);
                else{
                    ArrayList<Integer> li = new ArrayList<>();
                    li.add(val);
                    hm.put(pos,li);
                }
                if(node.left != null){
                    tempNodes.add(node.left);
                    tempPosi.add(pos-1);
                }
                if(node.right != null){
                    tempNodes.add(node.right);
                    tempPosi.add(pos+1);
                }
            }
            nodes = tempNodes;
            posi = tempPosi;
        }

        int[] keys = new int[hm.size()];
        int i = 0;
        for(int key:hm.keySet()){
            keys[i++] = key;
        }
        Arrays.sort(keys);
        for(int key:keys){
            ans.add(hm.get(key));
        }
        return ans;
    }
}
