package Hard;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, HashSet<Integer>> busesByStop = new HashMap();
        for(int i=0; i<routes.length; i++){
            for(int r:routes[i]){
                if(busesByStop.containsKey(r)) busesByStop.get(r).add(i);
                else{
                    HashSet<Integer> hs = new HashSet();
                    hs.add(i);
                    busesByStop.put(r,hs);
                }
            }
        }
        if(source == target) return 0;
        if(!busesByStop.containsKey(source)) return -1;
        else if(!busesByStop.containsKey(target)) return -1;
        HashSet<Integer> temp = busesByStop.get(source);
        Queue<Integer> nexts = new ArrayDeque();
        boolean[] visited = new boolean[routes.length];
        for(int firstBus:temp){
            nexts.add(firstBus);
            visited[firstBus] = true;
        }
        int ans = 1;
        while(!nexts.isEmpty()){
            Queue<Integer> nextTemp = new ArrayDeque();
            while(!nexts.isEmpty()){
                int bus = nexts.poll();
                int[] stops = routes[bus];
                for(int stop:stops){
                    if(stop == target) return ans;
                    HashSet<Integer> nextBuses = busesByStop.get(stop);
                    for(int b:nextBuses){
                        if(!visited[b]){
                            visited[b] = true;
                            nextTemp.add(b);
                        }
                    }
                }
            }
            ans++;
            nexts = nextTemp;
        }
        return -1;
    }
}
