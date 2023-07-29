package Medium;

public class PowXandN {
    public double myPow(double x, int n) {
        return betterPow(x, (long)n);
    }

    private double betterPow(double x, long n){
        if(n==0) return (double) 1;
        else if(n==1) return x;
        else{
            if(n<0){
                x = 1/x;
                n = -n;
            }
            double ans = betterPow(x*x, n/2);
            if(n%2==1) ans *= x;
            return ans;
        }
    }
}
