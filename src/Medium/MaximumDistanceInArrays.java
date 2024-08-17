package Medium;

import java.util.Arrays;
import java.util.List;

public class MaximumDistanceInArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int min1 = arrays.get(0).get(0);
        int min2 = arrays.get(1).get(0);
        if(min1>min2){
            int temp = min1;
            min1 = min2;
            min2 = temp;
        }
        int max1 = arrays.get(0).get(arrays.get(0).size()-1);
        int max2 = arrays.get(1).get(arrays.get(1).size()-1);
        if(max1>max2){
            int temp = max1;
            max1 = max2;
            max2 = temp;
        }

        for(int i=2; i<arrays.size(); i++){
            List<Integer> li = arrays.get(i);
            int min = li.get(0);
            int max = li.get(li.size()-1);
            if(min < min1){
                min2 = min1;
                min1 = min;
            } else if(min<min2){
                min2 = min;
            }
            if(max > max2){
                max2 = max1;
                max1 = max;
            } else if(max>max1){
                max1 = max;
            }
        }

        int ans = 0;
        for(List<Integer> li: arrays){
            int min = li.get(0);
            int max = li.get(li.size()-1);
            if(max == max2){
                ans = Math.max(ans,max1-min);
            } else ans = Math.max(ans,max2-min);
            if(min == min1){
                ans = Math.max(ans,max-min2);
            } else ans = Math.max(ans,max-min1);
        }

        return ans;
    }
}
