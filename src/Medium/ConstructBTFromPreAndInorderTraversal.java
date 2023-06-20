package Medium;

import java.util.Arrays;

public class ConstructBTFromPreAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recursiveBuild(preorder, inorder);
    }

    private TreeNode recursiveBuild(int[] pre, int[] in){
        if(pre.length == 0) return null;

        TreeNode top = new TreeNode(pre[0]);
        if(pre.length <= 2){
            if(pre.length == 2){
                if(pre[0] == in[0]) top.right =  new TreeNode(pre[1]);
                else top.left =  new TreeNode(pre[1]);
            }
            return top;
        }
        int idx = 0;
        while(in[idx] != pre[0]) idx++;
        top.left = recursiveBuild(Arrays.copyOfRange(pre, 1, idx+1), Arrays.copyOfRange(in, 0, idx));
        top.right = recursiveBuild(Arrays.copyOfRange(pre, idx+1, pre.length), Arrays.copyOfRange(in, idx+1, in.length));
        return top;
    }
}
