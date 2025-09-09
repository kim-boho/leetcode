package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String,TreeNode> ans = new HashMap<>();
        HashMap<String,TreeNode> makeNodeToString = new HashMap<>();
        String dummy = dfs(root,makeNodeToString,ans);

        List<TreeNode> ansList = new ArrayList<>();
        for(String key:ans.keySet()){
            ansList.add(ans.get(key));
        }
        return ansList;
    }

    private String dfs(TreeNode node, HashMap<String,TreeNode> makeNodeToString, HashMap<String,TreeNode> ans){
        if(node == null) return "x";
        String leftSub = dfs(node.left,makeNodeToString,ans);
        String rightSub = dfs(node.right,makeNodeToString,ans);
        String currentTree = node.val+","+leftSub+","+rightSub;
        if(makeNodeToString.containsKey(currentTree)){
            if(!ans.containsKey(currentTree)) ans.put(currentTree,node);
        } else{
            makeNodeToString.put(currentTree,node);
        }
        return currentTree;
    }
}
