package Medium;

public class ReverseInteger {
    public int reverse(int x) {
        int ans = 0;
        int count = 1;
        while(x != 0){
            int digit = x % 10;
            int prev = ans;
            ans *= 10;
            ans += digit;
            if((x>0 && ans<0) || (x<0 && ans>0)) return 0;
            x /= 10;
            if(ans/10 != prev) return 0;
        }
        return ans;
    }
}
