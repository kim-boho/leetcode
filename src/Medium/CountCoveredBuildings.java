package Medium;

import java.util.HashMap;

public class CountCoveredBuildings {
    public int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Integer,int[]> xMinAndMax = new HashMap();
        HashMap<Integer,int[]> yMinAndMax = new HashMap();
        for(int[] b:buildings){
            if(xMinAndMax.containsKey(b[0])){
                if(xMinAndMax.get(b[0])[0] > b[1]) xMinAndMax.get(b[0])[0] = b[1];
                else if(xMinAndMax.get(b[0])[1] < b[1]) xMinAndMax.get(b[0])[1] = b[1];
            } else{
                xMinAndMax.put(b[0],new int[]{b[1],b[1]});
            }

            if(yMinAndMax.containsKey(b[1])){
                if(yMinAndMax.get(b[1])[0] > b[0]) yMinAndMax.get(b[1])[0] = b[0];
                else if(yMinAndMax.get(b[1])[1] < b[0]) yMinAndMax.get(b[1])[1] = b[0];
            } else{
                yMinAndMax.put(b[1],new int[]{b[0],b[0]});
            }
        }
        int ans = 0;
        for(int[] b:buildings){
            int x = b[0];
            int y = b[1];
            if(xMinAndMax.get(x)[0] < y && xMinAndMax.get(x)[1] > y && yMinAndMax.get(y)[0] < x && yMinAndMax.get(y)[1] > x) ans++;
        }
        return ans;
    }
}
