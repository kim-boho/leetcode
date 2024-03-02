package Medium;

import java.util.ArrayList;

public class FindBottomLeftTreeValue {
    int depth = 0;
    int ans = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root,1);
        return ans;
    }

    private void dfs(TreeNode t, int tempDepth){
        if(depth < tempDepth){
            depth = tempDepth;
            ans = t.val;
        }
        if(t.left != null) dfs(t.left, tempDepth+1);
        if(t.right != null) dfs(t.right, tempDepth+1);
    }
}
