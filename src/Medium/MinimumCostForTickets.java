package Medium;

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        dp[0] = Math.min(Math.min(costs[0],costs[1]),costs[2]);
        int weekAgo = 0;
        int monthAgo = 0;
        for(int i=1; i<days.length; i++){
            int temp = dp[i-1]+costs[0];
            int d = days[i];
            while(weekAgo < i && days[weekAgo] <= d-7) weekAgo++;
            if(weekAgo == 0) temp = Math.min(temp,costs[1]);
            else temp = Math.min(temp,dp[weekAgo-1]+costs[1]);
            while(monthAgo < i && days[monthAgo] <= d-30) monthAgo++;
            if(monthAgo == 0) temp = Math.min(temp,costs[2]);
            else temp = Math.min(temp,dp[monthAgo-1]+costs[2]);
            dp[i] = temp;
        }
        return dp[dp.length-1];
    }
}
