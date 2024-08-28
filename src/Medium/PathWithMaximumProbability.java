package Medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class PathWithMaximumProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        HashMap<Integer, HashMap<Integer,Double>> hm = new HashMap<>();
        for(int i=0; i<edges.length; i++){
            int e1 = edges[i][0];
            int e2 = edges[i][1];
            double prob = succProb[i];
            if(hm.containsKey(e1)){
                hm.get(e1).put(e2,prob);
            } else{
                HashMap<Integer,Double> temp = new HashMap<Integer,Double>();
                temp.put(e2,prob);
                hm.put(e1,temp);
            }
            if(hm.containsKey(e2)){
                hm.get(e2).put(e1,prob);
            } else{
                HashMap<Integer,Double> temp = new HashMap<Integer,Double>();
                temp.put(e1,prob);
                hm.put(e2,temp);
            }
        }
        if(!hm.containsKey(start_node)) return 0;
        Queue<Integer> q = new LinkedList<>();
        double[] probs = new double[n];
        q.add(start_node);
        probs[start_node] = 1;
        while(!q.isEmpty()){
            int node = q.poll();
            HashMap<Integer,Double> nexts = hm.get(node);
            for(int i:nexts.keySet()){
                double temp = probs[node]*nexts.get(i);
                if(probs[i] < temp){
                    q.add(i);
                    probs[i] = temp;
                }
            }
        }
        return probs[end_node];
    }
}
