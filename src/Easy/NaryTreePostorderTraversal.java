package Easy;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        postOrder(ans, root);
        return ans;
    }

    private void postOrder(List<Integer> li, Node node){
        if(node == null) return;
        if(node.children == null){
            li.add(node.val);
            return;
        }
        for(Node n:node.children){
            postOrder(li, n);
        }
        li.add(node.val);
    }
}
