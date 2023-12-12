package Medium;

import java.util.*;

public class MostFrequentSubtreeSum {
    int max = 1;
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> hm = new HashMap();
        int total = helper(root, hm);
        ArrayList<Integer> ansLi = new ArrayList();
        Iterator it = hm.keySet().iterator();
        while(it.hasNext()){
            int key = (int) it.next();
            if(hm.get(key) == max) ansLi.add(key);
        }
        int[] ans = new int[ansLi.size()];
        for(int j=0; j<ans.length; j++) ans[j] = ansLi.get(j);
        return ans;
    }

    private int helper(TreeNode node, HashMap<Integer, Integer> hm){
        int value = node.val;
        if(node.left != null) value += helper(node.left, hm);
        if(node.right != null) value += helper(node.right, hm);

        if(hm.containsKey(value)){
            int temp = hm.get(value)+1;
            hm.put(value, temp);
            if(temp > max) max = temp;
        }
        else hm.put(value, 1);
        return value;
    }
}
