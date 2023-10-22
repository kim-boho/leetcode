package Medium;

import java.util.HashMap;

public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for(int i=0; i<points.length; i++){
            HashMap<Integer, Integer> ds = new HashMap();
            for(int j=0; j<points.length; j++){
                int dis = (int)Math.pow(Math.abs(points[i][0]-points[j][0]),2)+(int)Math.pow(Math.abs(points[i][1]-points[j][1]),2);
                if(ds.containsKey(dis)){
                    ans += ds.get(dis)*2;
                    ds.put(dis, ds.get(dis)+1);
                }
                else ds.put(dis,1);
            }
        }

        return ans;
    }
}
