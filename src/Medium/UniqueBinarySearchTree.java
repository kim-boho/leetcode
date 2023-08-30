package Medium;

public class UniqueBinarySearchTree {
    public int numTrees(int n) {
        if(n<3) return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] += dp[i-1]*2;
            int temp1 = i-2;
            int temp2 = 1;
            while(temp1 != 0 && temp2 != 0){
                dp[i] += (dp[temp1]*dp[temp2]);
                temp1--;
                temp2++;
            }
        }
        return dp[n];
    }
}
