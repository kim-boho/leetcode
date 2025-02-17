package Medium;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    Node2 prev;
    public Node2 treeToDoublyList(Node2 root) {
        if(root == null) return null;
        prev = new Node2(0);
        Node2 dummy = prev;
        inorder(root);
        prev.right = dummy.right;
        prev.right.left = prev;
        dummy.right = null;
        return prev.right;
    }

    private void inorder(Node2 node){
        if(node == null) return;
        inorder(node.left);
        prev.right = node;
        node.left = prev;
        prev = node;
        inorder(node.right);
    }
}