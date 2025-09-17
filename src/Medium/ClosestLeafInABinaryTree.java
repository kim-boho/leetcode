package Medium;

public class ClosestLeafInABinaryTree {
    int[] ans = new int[]{1000,-1};
    public int findClosestLeaf(TreeNode root, int k) {
        int[] min = dfs(root,k);
        if(ans[0] > min[0] && min[1] != k) return min[1];
        else return ans[1];
    }

    public int[] dfs(TreeNode node, int k){
        if(node == null) return new int[]{0,-1};
        if(node.left == null && node.right == null){
            if(node.val == k) ans = new int[]{0,k};
            return new int[]{1,node.val};
        }
        int[] left = dfs(node.left,k);
        int[] right = dfs(node.right,k);
        if(node.val == k){
            if(left[1] != -1 && left[0] < ans[0]) ans = left;
            if(right[1] != -1 && right[0] < ans[0]) ans = right;
            return new int[]{1,k};
        }
        if(left[1] == -1){
            right[0]++;
            return right;
        } else if(right[1] == -1){
            left[0]++;
            return left;
        } else{
            if(left[1] == k){
                if(ans[0] > left[0]+right[0]){
                    ans[0] = left[0]+right[0];
                    ans[1] = right[1];
                }
                left[0]++;
                return left;
            } else if(right[1] == k){
                if(ans[0] > left[0]+right[0]){
                    ans[0] = left[0]+right[0];
                    ans[1] = left[1];
                }
                right[0]++;
                return right;
            } else{
                if(left[0] > right[0]){
                    right[0]++;
                    return right;
                } else{
                    left[0]++;
                    return left;
                }
            }
        }
    }
}
