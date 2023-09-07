package Medium;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return constructNode(inorder, postorder);
    }

    private TreeNode constructNode(int[] subIn, int[] subPost){
        int n = subIn.length;
        if(n == 0) return null;
        else if(n == 1){
            return new TreeNode(subIn[0]);
        } else if(n == 2){
            TreeNode root = new TreeNode(subPost[1]);
            if(subIn[0] == subPost[0]){
                root.left = new TreeNode(subIn[0]);
            } else{
                root.right = new TreeNode(subIn[1]);
            }
            return root;
        } // base case

        int rootVal = subPost[n-1];
        TreeNode root = new TreeNode(rootVal);
        int inorderRootIdx = findIdx(subIn, rootVal);

        int[] leftSubIn = copyArray(0, inorderRootIdx-1, subIn);
        int[] rightSubIn = copyArray(inorderRootIdx+1, n-1, subIn);

        int[] leftSubPost = copyArray(0, inorderRootIdx-1, subPost);
        int[] rightSubPost = copyArray(inorderRootIdx, n-2, subPost);

        root.left = constructNode(leftSubIn, leftSubPost);
        root.right = constructNode(rightSubIn, rightSubPost);

        return root;
    }

    private int findIdx(int[] arr, int val){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == val) return i;
        }
        return -1;
    }

    private int[] copyArray(int start, int end, int[] arr){
        int[] ans = new int[end-start+1];
        for(int i= 0; i<ans.length; i++){
            ans[i] = arr[start++];
        }
        return ans;
    }
}
