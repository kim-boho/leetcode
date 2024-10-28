package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiameterOfNArayTree {
    int max = 0;
    public int diameter(TreeNode2 root) {
        int dummy = findDepth(root);
        return max;
    }

    private int findDepth(TreeNode2 node){
        List<TreeNode2> ch = node.children;
        if(ch.isEmpty()) return 1;
        else{
            int tempMax = 0;
            ArrayList<Integer> li = new ArrayList<>();
            for(TreeNode2 n:ch){
                int tempNum = findDepth(n);
                li.add(tempNum);
                tempMax = Math.max(tempMax,tempNum);
            }
            Collections.sort(li);
            int sz = li.size();
            if(li.size() > 1) max = Math.max(max,li.get(sz-1)+li.get(sz-2));
            else max = Math.max(max,li.get(sz-1));
            return tempMax+1;
        }
    }
}
class TreeNode2 {
    public int val;
    public List<TreeNode2> children;


    public TreeNode2() {
        children = new ArrayList<TreeNode2>();
    }

    public TreeNode2(int _val) {
        val = _val;
        children = new ArrayList<TreeNode2>();
    }

    public TreeNode2(int _val,ArrayList<TreeNode2> _children) {
        val = _val;
        children = _children;
    }
};
