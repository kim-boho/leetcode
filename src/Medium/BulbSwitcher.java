package Medium;

public class BulbSwitcher {
    public int bulbSwitch(int n) {
        int ans = 0;
        int square = 1;

        while(square * square <= n){
            ans++;
            square++;
        }

        return ans;
    }
}
