package Medium;

import java.util.Arrays;

public class BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        Arrays.sort(tokens);
        int p1 = 0;
        int p2 = n-1;
        int ans = 0;
        int score = 0;
        while(p1 <= p2){
            while(p1 < n && tokens[p1] <= power){
                power -= tokens[p1];
                p1++;
                score++;
            }
            ans = Math.max(ans,score);
            if(p1 == n) break;
            int next = tokens[p1];
            while(score > 0 && p2 >= p1 && p2 >= 0 && power < next){
                power += tokens[p2];
                p2--;
                score--;
            }
            if(power < next && score == 0) break;
        }
        return ans;
    }
}
