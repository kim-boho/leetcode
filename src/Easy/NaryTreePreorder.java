package Easy;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorder {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null) return ans;
        helper(root, ans);
        return ans;
    }

    private void helper(Node root, List<Integer> ans){
        ans.add(root.val);
        if(root.children.size() > 0){
            for(int i=0; i<root.children.size(); i++){
                helper(root.children.get(i), ans);
            }
        }
    }
}
