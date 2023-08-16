package Medium;

import java.util.ArrayList;

public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ArrayList<Integer> li = new ArrayList<>();
        while(head != null){
            li.add(head.val);
            head = head.next;
        }
        int mid = li.size()/2;
        TreeNode top = new TreeNode(li.get(mid));
        top.left = makeTree(top, 0, mid-1, li);
        top.right = makeTree(top, mid+1, li.size()-1, li);
        return top;
    }

    private TreeNode makeTree(TreeNode parent, int start, int end, ArrayList<Integer> li){
        if(start > end) return null;
        else if(start == end){
            return new TreeNode(li.get(start));
        } else if(end-start == 1){
            TreeNode child1 = new TreeNode(li.get(start));
            TreeNode child2 = new TreeNode(li.get(end));
            child1.right = child2;
            return child1;
        } else if(end-start == 2){
            TreeNode left = new TreeNode(li.get(start));
            TreeNode right = new TreeNode(li.get(end));
            TreeNode midNode = new TreeNode(li.get(start+1));
            midNode.left = left;
            midNode.right = right;
            return midNode;
        } else{
            int mid = (start+end)/2;
            TreeNode topNode = new TreeNode(li.get(mid));
            topNode.left = makeTree(topNode,start, mid-1, li);
            topNode.right = makeTree(topNode,mid+1, end, li);
            return topNode;
        }
    }
}
