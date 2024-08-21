package Medium;

public class TwoKeysKeyboard {
    int ans = Integer.MAX_VALUE;
    public int minSteps(int n) {
        if(n==1) return 0;
        dfs(1,1,n,1);
        return ans;
    }

    private void dfs(int count, int A, int n, int hold){
        if(A > n) return;
        if(A == n){
            ans = Math.min(ans, count);
            return;
        }
        dfs(count+2, A+hold, n, A+hold);
        dfs(count+1, A+hold, n, hold);
    }
}
