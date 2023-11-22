package Medium;

import java.util.*;

public class CloneGraph {
    public NeiNode cloneGraph(NeiNode node) {
        if(node == null) return null;
        if(node.neighbors.size() == 0) return new NeiNode(node.val);

        HashMap<Integer, NeiNode> copied = new HashMap();
        Queue<NeiNode> next = new LinkedList();
        HashSet<Integer> done = new HashSet();
        next.add(node);
        while(next.size() > 0){
            NeiNode current = next.poll();
            if(done.contains(current.val)) continue;
            NeiNode newOne = null;
            if(copied.containsKey(current.val)){
                newOne = copied.get(current.val);
            } else{
                newOne = new NeiNode(current.val);
                copied.put(newOne.val, newOne);
            }

            for(int i=0; i<current.neighbors.size(); i++){
                NeiNode nei = current.neighbors.get(i);
                next.add(nei);
                if(copied.containsKey(nei.val)){
                    newOne.neighbors.add(copied.get(nei.val));
                } else{
                    NeiNode tempNei = new NeiNode(nei.val);
                    newOne.neighbors.add(tempNei);
                    copied.put(nei.val, tempNei);
                }
            }
            done.add(current.val);
        }
        return copied.get(node.val);
    }
}

class NeiNode {
    public int val;
    public List<NeiNode> neighbors;
    public NeiNode() {
        val = 0;
        neighbors = new ArrayList<NeiNode>();
    }
    public NeiNode(int _val) {
        val = _val;
        neighbors = new ArrayList<NeiNode>();
    }
    public NeiNode(int _val, ArrayList<NeiNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
