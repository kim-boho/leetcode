package Medium;

import java.util.*;

public class MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> hm = new HashMap();
        int total = helper(root, hm);
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(hm.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        int size = entryList.size();
        int value = entryList.get(size-1).getValue();
        int i = size-1;
        ArrayList<Integer> ansLi = new ArrayList();
        while(i>=0 && entryList.get(i).getValue() == value) ansLi.add(entryList.get(i--).getKey());
        int[] ans = new int[ansLi.size()];
        for(int j=0; j<ans.length; j++) ans[j] = ansLi.get(j);
        return ans;
    }

    private int helper(TreeNode node, HashMap<Integer, Integer> hm){
        int value = node.val;
        if(node.left != null) value += helper(node.left, hm);
        if(node.right != null) value += helper(node.right, hm);

        if(hm.containsKey(value)) hm.put(value, hm.get(value)+1);
        else hm.put(value, 1);
        return value;
    }
}
