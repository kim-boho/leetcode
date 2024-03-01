package Medium;

import java.util.ArrayList;

public class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        ArrayList<TreeNode> li = new ArrayList();
        li.add(root);
        boolean isEven = true;
        while(!li.isEmpty()){
            ArrayList<TreeNode> temp = new ArrayList();
            int prev = isEven? -1:1000001;
            for(TreeNode t:li){
                if(isEven){
                    if(t.val % 2 == 0 || t.val <= prev) return false;
                } else{
                    if(t.val % 2 == 1 || t.val >= prev) return false;
                }
                prev = t.val;
                if(t.left != null) temp.add(t.left);
                if(t.right != null) temp.add(t.right);
            }
            isEven = !isEven;
            li = temp;
        }
        return true;
    }
}
