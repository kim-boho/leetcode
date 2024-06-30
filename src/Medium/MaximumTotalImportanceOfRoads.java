package Medium;

import java.util.Arrays;

public class MaximumTotalImportanceOfRoads {
    public long maximumImportance(int n, int[][] roads) {
        int[] vertices = new int[n];
        for (int[] road : roads) {
            vertices[road[0]]++;
            vertices[road[1]]++;
        }
        Arrays.sort(vertices);
        long ans = 0;
        for(int i=1; i<=n; i++){
            ans += (long)vertices[i-1]*i;
        }
        return ans;
    }
}
