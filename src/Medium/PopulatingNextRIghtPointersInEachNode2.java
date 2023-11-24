package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRIghtPointersInEachNode2 {
    public NodeWithNext connect(NodeWithNext root) {
        if(root == null) return null;
        Queue<NodeWithNext> q = new LinkedList();
        q.add(root);
        while(q.size() > 0){
            Queue<NodeWithNext> temp = new LinkedList();
            while(q.size() > 0){
                NodeWithNext n = q.poll();
                if(n.left != null) temp.add(n.left);
                if(n.right != null) temp.add(n.right);
                if(q.size() > 0){
                    n.next = q.peek();
                }
            }
            q = temp;
        }

        return root;
    }
}

class NodeWithNext {
    public int val;
    public NodeWithNext left;
    public NodeWithNext right;
    public NodeWithNext next;

    public NodeWithNext() {}

    public NodeWithNext(int _val) {
        val = _val;
    }

    public NodeWithNext(int _val, NodeWithNext _left, NodeWithNext _right, NodeWithNext _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
