package Medium;

import java.util.HashSet;

public class LowestCommonAncestorOfABinaryTree3 {
    public NodeWithP lowestCommonAncestor(NodeWithP p, NodeWithP q) {
        HashSet<Integer> ancs = new HashSet<>();
        while(p != null){
            ancs.add(p.val);
            p = p.parent;
        }

        while(q != null){
            if(ancs.contains(q.val)) return q;
            q = q.parent;
        }
        return null;
    }
}
class NodeWithP {
    public int val;
    public NodeWithP left;
    public NodeWithP right;
    public NodeWithP parent;
};
