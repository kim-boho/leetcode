package Easy;

public class UglyNumber {
    public boolean isUgly(int n) {
        if(n==1) return true;
        while(n>0){
            int temp = n;
            if(n % 15 == 0) n /= 15;
            if(n % 10 == 0) n /= 10;
            if(n % 6 == 0) n /= 6;
            if(n % 5 == 0) n /= 5;
            if(n % 3 == 0) n /= 3;
            if(n % 2 == 0) n /= 2;
            if(temp == n) return false;
            if(n == 1) return true;
        }

        return false;
    }
}
