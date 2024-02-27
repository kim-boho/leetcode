package Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer,HashMap<Integer,Integer>> route = new HashMap();
        for(int[] f: flights){
            int start = f[0];
            int arrive = f[1];
            int weight = f[2];
            if(route.containsKey(start)){
                route.get(start).put(arrive,weight);
            } else{
                HashMap<Integer,Integer> temp = new HashMap();
                temp.put(arrive,weight);
                route.put(start,temp);
            }
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ans[src] = 0;
        HashSet<Integer> li = new HashSet();
        li.add(src);

        for(int i=0; i<=k; i++){
            int[] temp = Arrays.copyOf(ans,n);
            HashSet<Integer> temp2 = new HashSet();
            for(Integer j:li){
                HashMap<Integer,Integer> nexts = route.get(j);
                if(nexts == null) continue;
                for(Integer arrive:nexts.keySet()){
                    if(temp[arrive] == -1 || temp[arrive] > ans[j]+nexts.get(arrive)){
                        temp[arrive] = ans[j]+nexts.get(arrive);
                        temp2.add(arrive);
                    }
                }
            }
            ans = temp;
            li = temp2;
        }
        return ans[dst];
    }
}
