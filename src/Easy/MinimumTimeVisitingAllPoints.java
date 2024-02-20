package Easy;

public class MinimumTimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for(int i=0; i<points.length-1; i++){
            int x = points[i][0];
            int y = points[i][1];
            int x2 = points[i+1][0];
            int y2 = points[i+1][1];
            int diag = Math.min(Math.abs(x-x2),Math.abs(y-y2));
            int remaining = Math.abs(Math.max(Math.abs(x-x2),Math.abs(y-y2)) - diag);
            ans += (diag+remaining);
        }
        return ans;
    }
}
