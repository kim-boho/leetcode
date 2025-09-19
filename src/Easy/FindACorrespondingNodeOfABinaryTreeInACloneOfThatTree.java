package Easy;

import Medium.TreeNode;

public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null) return null;
        else if(target == original) return cloned;
        else{
            TreeNode left = getTargetCopy(original.left,cloned.left,target);
            TreeNode right = getTargetCopy(original.right,cloned.right,target);
            if(left == null) return right;
            else return left;
        }
    }
}
