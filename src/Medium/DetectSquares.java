package Medium;

import java.util.HashMap;

public class DetectSquares {
    HashMap<Integer,HashMap<Integer,Integer>> xs;
    HashMap<Integer,HashMap<Integer,Integer>> ys;
    public DetectSquares() {
        xs = new HashMap<>();
        ys = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        if(!xs.containsKey(x)) xs.put(x,new HashMap<>());
        xs.get(x).put(y,xs.get(x).getOrDefault(y,0)+1);
        if(!ys.containsKey(y)) ys.put(y,new HashMap<>());
        ys.get(y).put(x,ys.get(y).getOrDefault(x,0)+1);
        return;
    }

    public int count(int[] point) {
        int ans = 0;
        int x = point[0];
        int y = point[1];
        HashMap<Integer,Integer> allYs = xs.get(x);
        if(allYs == null) return 0;
        for(int key:allYs.keySet()){
            int nums = allYs.get(key);
            if(key != y){
                int len = key > y? key-y:y-key;
                if(ys.containsKey(y) && ys.get(y).containsKey(x-len) && ys.containsKey(key) && ys.get(key).containsKey(x-len)){
                    ans += (ys.get(y).get(x-len)*ys.get(key).get(x-len)*nums);
                }
                if(ys.containsKey(y) && ys.get(y).containsKey(x+len) && ys.containsKey(key) && ys.get(key).containsKey(x+len)){
                    ans += (ys.get(y).get(x+len)*ys.get(key).get(x+len)*nums);
                }
            }
        }
        return ans;
    }
}
