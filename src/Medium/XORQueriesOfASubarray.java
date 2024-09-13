package Medium;

public class XORQueriesOfASubarray {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] preSum = new int[arr.length];
        preSum[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            preSum[i] = preSum[i-1]^arr[i];
        }
        int[] ans = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int[] q = queries[i];
            if(q[0] == q[1]) ans[i] = arr[q[0]];
            else{
                int temp = preSum[q[1]];
                if(q[0] > 0){
                    temp = temp^preSum[q[0]-1];
                }
                ans[i] = temp;
            }
        }
        return ans;
    }
}
