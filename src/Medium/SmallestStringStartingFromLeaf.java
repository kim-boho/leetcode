package Medium;

import java.util.ArrayList;

public class SmallestStringStartingFromLeaf {
    String ans = null;
    public String smallestFromLeaf(TreeNode root) {
        ArrayList<Integer> li = new ArrayList<>();
        helper(li, root);
        return ans;
    }

    private void helper(ArrayList<Integer> li, TreeNode node){
        if(node.left == null && node.right == null){
            li.add(node.val);
            StringBuilder sb = new StringBuilder();
            for(int i=li.size()-1; i>=0; i--){
                sb.append((char)(li.get(i)+'a'));
            }
            if(ans == null) ans = sb.toString();
            else{
                if(ans.compareTo(sb.toString()) > 0){
                    ans = sb.toString();
                }
            }
            li.remove(li.size()-1);
            return;
        }
        if(node.left != null){
            li.add(node.val);
            helper(li, node.left);
            li.remove(li.size()-1);
        }
        if(node.right != null){
            li.add(node.val);
            helper(li, node.right);
            li.remove(li.size()-1);
        }
    }
}
