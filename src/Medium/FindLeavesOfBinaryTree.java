package Medium;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int num = countFromLeaves(root,ans);
        return ans;
    }

    private int countFromLeaves(TreeNode node, List<List<Integer>> ans){
        if(node.left == null && node.right == null){
            if(ans.size() == 0) ans.add(new ArrayList<>());
            ans.get(0).add(node.val);
            return 1;
        }
        int leftLeafCount = node.left == null? 0:countFromLeaves(node.left,ans);
        int rightLeafCount = node.right == null? 0:countFromLeaves(node.right,ans);
        int leavesCount = Math.max(leftLeafCount,rightLeafCount);
        if(ans.size() < leavesCount+1) ans.add(new ArrayList<>());
        ans.get(leavesCount).add(node.val);
        return leavesCount+1;
    }
}
