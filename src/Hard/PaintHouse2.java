package Hard;

public class PaintHouse2 {
    public int minCostII(int[][] costs) {
        int cost = 0;
        int[][] dp = new int[costs.length+1][3];
        dp[0][2] = -1;
        for(int i=0; i<costs.length; i++){
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            int minIdx = -1;
            for(int j=0; j<costs[i].length; j++){
                if(dp[i][2] == j) costs[i][j] += dp[i][1];
                else costs[i][j] += dp[i][0];
                if(min1 > costs[i][j]){
                    min2 = min1;
                    min1 = costs[i][j];
                    minIdx = j;
                } else if(min1 == costs[i][j]) min2 = min1;
                else if(min2 > costs[i][j]) min2 = costs[i][j];
                dp[i+1][0] = min1;
                dp[i+1][1] = min2;
                dp[i+1][2] = minIdx;
            }
        }
        return dp[costs.length][0];
    }
}
