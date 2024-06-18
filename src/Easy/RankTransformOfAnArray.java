package Easy;

import java.util.Arrays;

public class RankTransformOfAnArray {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length == 0) return new int[]{};
        int[][] copied = new int[arr.length][2];
        for(int i=0; i<arr.length; i++){
            copied[i][0] = arr[i];
            copied[i][1] = i;
        }
        Arrays.sort(copied);
        int p = 1;
        int[] ans = new int[arr.length];
        int prev = copied[0][0];
        for(int i=0; i<arr.length; i++){
            if(copied[i][0] == prev) ans[copied[i][1]] = p;
            else{
                prev = copied[i][0];
                p++;
                ans[copied[i][1]] = p;
            }
        }
        return ans;
    }
}
