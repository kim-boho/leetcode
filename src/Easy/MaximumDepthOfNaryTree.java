package Easy;

import java.util.List;

public class MaximumDepthOfNaryTree {
    int ans = 0;
    public int maxDepth(Node root) {
        if(root == null) return 0;
        helper(root, 1);
        return ans;
    }

    private void helper(Node node, int count){
        if(count > ans) ans = count;
        for(Node n:node.children){
            helper(n, count+1);
        }
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
