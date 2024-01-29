package Medium;

import java.util.ArrayList;
import java.util.TreeMap;

public class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        int len = points.length;
        TreeMap<Integer, ArrayList<int[]>> hm = new TreeMap();
        int[][] manDist = new int[len][len];
        for(int i=0; i<len; i++){
            int[] p1 = points[i];
            for(int j=i+1; j<len; j++){
                int[] p2 = points[j];
                int dist = Math.abs(p1[0]-p2[0])+Math.abs(p1[1]-p2[1]);
                manDist[i][j] = dist;
                if(hm.get(dist) == null){
                    ArrayList<int[]> li = new ArrayList();
                    hm.put(dist,li);
                }
                hm.get(dist).add(new int[]{i,j});
            }
        }
        int setNum = 1;
        int ans = 0;
        int count = 0;
        int[] checked = new int[len];
        for(Integer i:hm.keySet()){
            ArrayList<int[]> li = hm.get(i);
            for (int[] ints : li) {
                int p1 = ints[0];
                int p2 = ints[1];
                if (checked[p1] == 0 && checked[p2] == 0) {
                    checked[p1] = setNum;
                    checked[p2] = setNum;
                    setNum++;
                    ans += manDist[p1][p2];
                    count++;
                } else if (checked[p1] == 0 || checked[p2] == 0) {
                    int temp = checked[p1] == 0 ? checked[p2] : checked[p1];
                    checked[p1] = temp;
                    checked[p2] = temp;
                    count++;
                    ans += manDist[p1][p2];
                } else {
                    if (checked[p1] != checked[p2]) {
                        int temp = checked[p1];
                        int temp2 = checked[p2];
                        for (int j = 0; j < checked.length; j++) {
                            if (checked[j] == temp) checked[j] = temp2;
                        }
                        count++;
                        ans += manDist[p1][p2];
                    }
                }
                if (count == len - 1) return ans;
            }
            if(count == len-1) return ans;
        }
        return ans;
    }
}
