package Medium;

public class DecodeWays {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        if(s.charAt(0) != '0') dp[1] = 1;
        else return 0;

        for(int i=2; i<=s.length(); i++){
            int current = s.charAt(i-1)-'0';
            int prev = s.charAt(i-2)-'0';
            if(!(prev==1 || prev==2) && current==0) return 0;
            if(current != 0) dp[i] += dp[i-1];
            if(prev == 1 || (prev == 2 && current <= 6)) dp[i] += dp[i-2];
        }
        return dp[s.length()];
    }
}
