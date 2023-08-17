package Medium;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        List<Integer> temp = new ArrayList<>();
        addChild(root, targetSum, 0, ans, temp);
        return ans;
    }
    private void addChild(TreeNode node, int targetSum, int sum, List<List<Integer>> ans, List<Integer> temp){
        sum += node.val;
        temp.add(node.val);
        if(node.left == null && node.right == null){
            if(sum == targetSum){
                ArrayList<Integer> temp2 = new ArrayList<>();
                for(int i:temp) temp2.add(i);
                ans.add(temp2);
            }
        } else{
            if(node.left == null){
                addChild(node.right, targetSum, sum, ans, temp);
            } else if(node.right == null){
                addChild(node.left, targetSum, sum, ans, temp);
            } else{
                addChild(node.left, targetSum, sum, ans, temp);
                addChild(node.right, targetSum, sum, ans, temp);
            }
        }
        temp.remove(temp.size()-1);
    }
}
