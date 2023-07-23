package Easy;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int ans = 0;
        int num = n;
        if(n<0) num = Math.abs(n+1);
        while(num>0){
            if(num%2 == 1) ans++;
            num /= 2;
        }

        return n<0? 32-ans:ans;
    }
}
