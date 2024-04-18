package Easy;

public class CalculateMoneyInLeetcodeBank {
    public int totalMoney(int n) {
        int num = 0;
        int i=7;
        int ans = 0;
        while(i <= n){
            ans += 28+num*7;
            num++;
            i += 7;
        }
        if(n % 7 != 0){
            int j = n % 7;
            ans += j*(j+1)/2+num*j;
        }
        return ans;
    }
}
