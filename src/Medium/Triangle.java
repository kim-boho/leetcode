package Medium;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=1; i<triangle.size(); i++){
            List<Integer> pre = triangle.get(i-1);
            List<Integer> li = triangle.get(i);
            for(int j=0; j<li.size(); j++){
                int min =0;
                if(j == 0) min = pre.get(0);
                else if(j == li.size()-1){
                    min = pre.get(li.size()-2);
                } else{
                    min = Math.min(pre.get(j), pre.get(j-1));
                }
                li.set(j, min + li.get(j));
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<triangle.get(triangle.size()-1).size(); i++){
            if(min>triangle.get(triangle.size()-1).get(i)) min = triangle.get(triangle.size()-1).get(i);
        }
        return min;
    }
}
