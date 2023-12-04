package Easy;

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        int ans = 0;
        int stair = 1;
        while(n - stair >= 0){
            ans++;
            n -= stair;
            stair++;
        }
        return ans;
    }
}
