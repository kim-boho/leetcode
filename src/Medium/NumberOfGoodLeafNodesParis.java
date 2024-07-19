package Medium;

import java.util.ArrayList;
import java.util.Collections;

public class NumberOfGoodLeafNodesParis {
    int ans = 0;
    public int countPairs(TreeNode root, int distance) {
        recursion(root,distance,1);
        return ans;
    }

    private ArrayList<Integer> recursion(TreeNode t, int distance, int depth){
        if(t.left == null && t.right == null){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(depth);
            return temp;
        }
        if(t.left != null && t.right != null){
            ArrayList<Integer> left = recursion(t.left,distance,depth+1);
            ArrayList<Integer> right = recursion(t.right,distance,depth+1);
            System.out.println(t.val+", "+left+" "+right);
            for(int l:left){
                for(int r:right){
                    int gap = Math.abs((r-depth)+(l-depth));
                    if(gap>distance) break;
                    ans++;
                }
            }
            left.addAll(right);
            Collections.sort(left);
            return left;
        } else if(t.left == null){
            return recursion(t.right,distance,depth+1);
        } else{
            return recursion(t.left,distance,depth+1);
        }
    }
}
