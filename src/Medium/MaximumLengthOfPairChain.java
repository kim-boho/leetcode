package Medium;

import java.util.Arrays;

public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        if(n<2) return n;
        int ans = 0;
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 1;
        int max = pairs[0][1];
        while(i < pairs.length){
            if(pairs[i][0] > max){
                ans++;
                max = pairs[i][1];
            } else max = Math.min(max,pairs[i][1]);
            i++;
        }
        ans++;
        return ans;
    }
}
