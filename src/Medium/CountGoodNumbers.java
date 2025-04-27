package Medium;

public class CountGoodNumbers {
    long mod = 1000000007;
    public int countGoodNumbers(long n) {
        long even = n/2;
        long odd = n/2;
        if(n % 2 == 1) even++;
        return (int)((recursion(5,even)*recursion(4,odd))%mod);
    }

    private long recursion(long base, long exp){
        long ans = 1;
        while(exp > 0){
            if(exp % 2 == 1) ans = (ans*base)%mod;
            base = (base*base)%mod;
            exp /= 2;
        }
        return ans;
    }
}
