package Hard;

import java.util.HashMap;

public class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        if(points.length == 0) return 0;
        int ans = 1;
        for(int i=0; i<points.length; i++){
            int vertical = 1;
            int horizontal = 1;
            int x = points[i][0];
            int y = points[i][1];
            HashMap<Double, Integer> hm = new HashMap<>();
            for(int j=i+1; j<points.length; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                if(y==y2) vertical++;
                if(x==x2) horizontal++;
                else{
                    double slope = 0;
                    if(x>x2){
                        slope = (double)(x-x2)/(double)(y-y2);
                    } else{
                        slope = (double)(x2-x)/(double)(y2-y);
                    }
                    if(hm.containsKey(slope)){
                        hm.put(slope, hm.get(slope)+1);
                        if(ans<hm.get(slope)) ans = hm.get(slope);
                    } else{
                        hm.put(slope, 2);
                        if(ans<hm.get(slope)) ans = hm.get(slope);
                    }
                }
            }
            if(ans<horizontal) ans = horizontal;
            if(ans<vertical) ans = vertical;
        }
        return ans;
    }
}
