package Easy;

import java.util.Arrays;

public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int ans = 0;
        int prev = points[0][0];
        for(int i=1; i<points.length; i++){
            if(points[i][0] != prev){
                int diff = points[i][0]-prev;
                ans = ans<diff? diff:ans;
                prev = points[i][0];
            }
        }
        return ans;
    }
}
