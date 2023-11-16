package Medium;

import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int[] arr = new int[timePoints.size()];
        for(int i=0; i<timePoints.size(); i++){
            String s = timePoints.get(i);
            String[] hours = s.split(":");
            int h = Integer.parseInt(hours[0]);
            int m = Integer.parseInt(hours[1]);
            arr[i] = h*60 + m;
        }
        Arrays.sort(arr);

        int ans = Integer.MAX_VALUE;
        for(int i=1; i<arr.length; i++){
            if(ans > arr[i]-arr[i-1]) ans = arr[i]-arr[i-1];
        }
        if(60*24 - arr[arr.length-1] + arr[0] < ans) ans = 60*24 - arr[arr.length-1] + arr[0];
        return ans;
    }
}
