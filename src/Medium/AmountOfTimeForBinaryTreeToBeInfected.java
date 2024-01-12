package Medium;

import java.util.ArrayList;
import java.util.HashMap;

public class AmountOfTimeForBinaryTreeToBeInfected {
    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer, TreeNode> hm = new HashMap();
        HashMap<Integer, Integer> parents = new HashMap();
        mapping(root, hm, parents, null);
        ArrayList<Integer> li = new ArrayList();
        li.add(start);
        int ans = 0;
        while(li.size() > 0){
            ArrayList<Integer> temp = new ArrayList();
            for(int i=0; i<li.size(); i++){
                TreeNode t = hm.get(li.get(i));
                if(t.left != null && hm.containsKey(t.left.val)) temp.add(t.left.val);
                if(t.right != null && hm.containsKey(t.right.val)) temp.add(t.right.val);
                if(hm.containsKey(parents.get(t.val))) temp.add(parents.get(t.val));
                hm.remove(t.val);
            }
            li = temp;
            ans++;
        }
        return --ans;
    }

    private void mapping(TreeNode node, HashMap<Integer, TreeNode> hm, HashMap<Integer, Integer> parents, Integer parentVal){
        parents.put(node.val, parentVal);
        hm.put(node.val, node);
        if(node.left != null) mapping(node.left, hm, parents, node.val);
        if(node.right != null) mapping(node.right, hm, parents, node.val);
    }
}
