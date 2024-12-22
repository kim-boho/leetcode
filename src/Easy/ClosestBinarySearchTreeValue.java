package Easy;

import Medium.TreeNode;

public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        if(target <= 0){
            if(root.left != null) return closestValue(root.left,target);
            else return root.val;
        } else{
            if(Math.abs((double)root.val-target) < 0.5) return root.val;
            if((double)root.val > target){
                if(root.left != null){
                    int temp = closestValue(root.left,target);
                    if(Math.abs(temp-target) <= Math.abs(root.val-target)) return temp;
                    else return root.val;
                } else return root.val;
            } else {
                if(root.right != null){
                    int temp = closestValue(root.right,target);
                    if(Math.abs(temp-target) < Math.abs(root.val-target)) return temp;
                    else return root.val;
                } else return root.val;
            }
        }
    }
}
