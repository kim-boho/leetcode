package Medium;

public class CountNodesWithTheHighestScore {
    public int countHighestScoreNodes(int[] parents) {
        Integer[][] nodes = new Integer[parents.length][4];
        for(int i=0; i<parents.length; i++){
            int p = parents[i];
            nodes[i][0] = p;
            if(p != -1){
                if(nodes[p][1] == null) nodes[p][1] = i;
                else nodes[p][2] = i;
            }
        }
        for(int i=0; i<nodes.length; i++){
            if(nodes[i][3] == null) calculateSubtreeSize(nodes,i);
        }
        int n = parents.length;
        long max = 0;
        int count = 0;
        for(int i=0; i<nodes.length; i++){
            long par = nodes[i][3] == n? 1:n-nodes[i][3];
            long left = nodes[i][1] == null? 1:nodes[nodes[i][1]][3];
            long right = nodes[i][2] == null? 1:nodes[nodes[i][2]][3];
            if(max < par*left*right){
                count = 1;
                max = par*left*right;
            } else if(max == par*left*right) count++;
        }
        return count;
    }

    private void calculateSubtreeSize(Integer[][] nodes, int i){
        if(nodes[i][1] == null && nodes[i][2] == null){
            nodes[i][3] = 1;
            return;
        }
        int size = 1;
        if(nodes[i][1] != null){
            int left = nodes[i][1];
            if(nodes[left][3] == null) calculateSubtreeSize(nodes,left);
            size += nodes[left][3];
        }
        if(nodes[i][2] != null){
            int right = nodes[i][2];
            if(nodes[right][3] == null) calculateSubtreeSize(nodes,right);
            size += nodes[right][3];
        }
        nodes[i][3] = size;
    }
}
