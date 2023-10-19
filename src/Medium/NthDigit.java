package Medium;

public class NthDigit {
    public int findNthDigit(int n) {
        if(n < 10) return n;
        long num = 0;
        long digitNum = 1;
        long nines = 9;
        long prev = 0;
        while(num < n){
            prev = num;
            num += digitNum*nines;
            nines *= 10;
            digitNum++;
        }
        n -= prev;
        digitNum--;
        n--;
        long jump = n/digitNum;
        long target = (long)Math.pow(10,digitNum-1) + (long)jump;
        long remaining = n % digitNum;
        String st = String.valueOf(target);
        char c = st.charAt((int)remaining);
        return c-'0';
    }
}
