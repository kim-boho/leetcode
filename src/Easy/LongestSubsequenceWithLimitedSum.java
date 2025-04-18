package Easy;

import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum {
    public int[] answerQueries(int[] nums, int[] queries) {
        int m = queries.length;
        int[] ans = new int[m];
        Arrays.sort(nums);
        int[][] qrWithIdx = new int[m][2];
        for(int i=0; i<m; i++){
            qrWithIdx[i] = new int[]{queries[i],i};
        }
        Arrays.sort(qrWithIdx, (a,b) -> a[0]-b[0]);
        int sum = 0;
        int idx = 0;
        int i = 0;
        while(idx < m){
            while(i < nums.length && idx < m && sum+nums[i] <= qrWithIdx[idx][0]){
                sum += nums[i++];
            }
            ans[qrWithIdx[idx++][1]] = i;
        }
        return ans;
    }
}
