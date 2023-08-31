package Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class UniqueBinarySearchTree2 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList();
        List<TreeNode>[] arr = new ArrayList[n+1];

        for(int i=0; i<arr.length; i++){
            arr[i] = new ArrayList<TreeNode>();
        }
        arr[1].add(new TreeNode(1));

        for(int i=2; i<=n; i++){
            TreeNode head = new TreeNode(i);
            for(int j=0; j<i; j++){
                int leftNum = j;
                int rightNum = i-j-1;
                List<TreeNode> leftChild = arr[leftNum];
                List<TreeNode> rightChild = arr[rightNum];

                if(leftNum == 0){
                    for(int r=0; r<rightChild.size(); r++){
                        head.right = rightChild.get(r);
                        TreeNode newHead = new TreeNode(-1);
                        deepCopy(head, newHead);
                        Stack<Integer> st = new Stack();
                        for(int k=n; k>0; k--) st.add(k);
                        inorder(st, newHead);
                        arr[i].add(newHead);
                        head.right = null;
                    }
                } else if(rightNum == 0){
                    for(int l=0; l<leftChild.size(); l++){
                        head.left = leftChild.get(l);
                        TreeNode newHead = new TreeNode(-1);
                        deepCopy(head, newHead);
                        Stack<Integer> st = new Stack();
                        for(int k=n; k>0; k--) st.add(k);
                        inorder(st, newHead);
                        arr[i].add(newHead);
                        head.left = null;
                    }
                } else{
                    for(int l=0; l<leftChild.size(); l++){
                        for(int r=0; r<rightChild.size(); r++){
                            head.left = leftChild.get(l);
                            head.right = rightChild.get(r);
                            TreeNode newHead = new TreeNode(-1);
                            deepCopy(head, newHead);
                            Stack<Integer> st = new Stack();
                            for(int k=n; k>0; k--) st.add(k);
                            inorder(st, newHead);
                            arr[i].add(newHead);
                            head.left = null;
                            head.right = null;
                        }
                    }
                }
            }
        }

        return arr[n];

    }

    private void deepCopy(TreeNode head, TreeNode newHead){
        if(head.left != null){
            newHead.left = new TreeNode(-1);
            deepCopy(head.left, newHead.left);
        }
        if(head.right != null){
            newHead.right = new TreeNode(-1);
            deepCopy(head.right, newHead.right);
        }
    }

    private void inorder(Stack<Integer> st, TreeNode head){
        if(head == null) return;
        inorder(st, head.left);
        head.val = st.pop();
        inorder(st, head.right);
    }
}