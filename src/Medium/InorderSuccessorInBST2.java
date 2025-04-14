package Medium;

public class InorderSuccessorInBST2 {
    public Node3 inorderSuccessor(Node3 node) {
        if(node.right == null){
            while(node.parent != null && node.parent.right == node) node = node.parent;
            return node.parent;
        }
        return findSuccessor(node.right);
    }

    private Node3 findSuccessor(Node3 node){
        if(node.left != null) {
            return findSuccessor(node.left);
        }
        return node;
    }
}

class Node3 {
    public int val;
    public Node3 left;
    public Node3 right;
    public Node3 parent;
};
