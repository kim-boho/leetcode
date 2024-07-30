package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(NaryNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<NaryNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            ArrayList<Integer> li = new ArrayList<>();
            Queue<NaryNode> temp = new LinkedList<>();
            while(!q.isEmpty()){
                NaryNode n = q.poll();
                li.add(n.val);
                if(n.children != null){
                    for(NaryNode child:n.children){
                        temp.add(child);
                    }
                }
            }
            ans.add(li);
            q = temp;
        }
        return ans;
    }
}
