package Hard;

import java.util.ArrayList;

public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        int rSum = 0;
        int cSum = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    rows.add(i);
                    rSum += i;
                    cols.add(j);
                    cSum += j;
                }
            }
        }
        int r = rSum/rows.size();
        int c = cSum/cols.size();
        int ans = 0;
        int dist1 = getDists(r,rows);
        for(int i=r-4; i<=r+4; i++){
            if(i != r && i >= 0 && i < m) dist1 = Math.min(dist1,getDists(i,rows));
        }

        int dist2 = getDists(c,cols);
        for(int i=c-4; i<=c+4; i++){
            if(i != c && i >= 0 && i < n) dist2 = Math.min(dist2,getDists(i,cols));
        }

        return dist1+dist2;
    }

    private int getDists(int center, ArrayList<Integer> nums){
        int sum = 0;
        for(int i=0; i<nums.size(); i++){
            sum += Math.abs(center-nums.get(i));
        }
        return sum;
    }
}
