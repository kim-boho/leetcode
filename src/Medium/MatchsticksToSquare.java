package Medium;

public class MatchsticksToSquare {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length < 4) return false;

        int sum = 0;
        int max = 0;
        for(int i:matchsticks){
            sum += i;
            if(i>max) max = i;
        }

        if(sum % 4 != 0 || sum/4 < max) return false;
        else{
            int width = sum/4;
            int[] count = new int[4];
            return dfs(matchsticks, width, count, 0);

        }
    }

    private boolean dfs(int[] matchsticks, int width, int count[], int idx){
        if(idx == matchsticks.length) return true;

        for(int i=0; i<4; i++){
            if(count[i] + matchsticks[idx] > width) continue;
            count[i] += matchsticks[idx];
            if(dfs(matchsticks, width, count, idx+1)) return true;
            count[i] -= matchsticks[idx];
        }
        return false;
    }
}
