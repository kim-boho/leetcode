package Medium;

public class DivideTwoIntegers {

    public static void main(String[] args) {
        DivideTwoIntegers obj = new DivideTwoIntegers();
        System.out.println(obj.divide2(30, 2));
    }

    public int divide2(int dividend, int divisor){
        if(dividend == 0 || divisor == 0) return 0;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
        if(dividend == Integer.MAX_VALUE && divisor == 1) return Integer.MAX_VALUE;
        if(dividend == Integer.MAX_VALUE && divisor == -1) return -Integer.MAX_VALUE;
        boolean isPositive = (dividend>0 && divisor>0) || (dividend<0 && divisor<0) ? true:false;
        int absDivisor = Math.abs(divisor);
        int absDividend = Math.abs(dividend);
        int quotient = 0;
        while(absDividend>=absDivisor){
            int bitShift = 0;
            while(absDividend >= (absDivisor << bitShift)){
                bitShift++;
            }
            int currentQuotient = 1 << (bitShift-1);
            quotient += currentQuotient;
            absDividend -= absDivisor << (bitShift-1);
        }
        return isPositive? quotient:-1*quotient;
    }

    public int divide(int dividend, int divisor) {
        if(dividend == 0 || divisor == 0) return 0;

        if(divisor == 2147483647){
            if(dividend == 2147483647) return 1;
            else if(dividend == -2147483648 || dividend == -2147483647) return -1;
            else return 0;
        } else if(divisor == -2147483648){
            if(dividend == -2147483648) return 1;
            else return 0;
        }

        if(dividend == 2147483647){
            if(divisor == 1) return 2147483647;
            else if(divisor == -1) return -2147483647;
        } else if(dividend == -2147483648){
            if(divisor == 1) return -2147483648;
            else if(divisor == -1) return 2147483647;
        }

        int quot = 0;
        int absDivisor = Math.abs(divisor);
        boolean isPositive = false;
        if((dividend>0 && divisor>0) || (dividend<0 && divisor<0)) isPositive = true;
        if(dividend<0){
            while(dividend<0){
                dividend += absDivisor;
                quot++;
            }
        } else{
            while(dividend>0){
                dividend -= absDivisor;
                quot++;
            }
        }

        if(dividend != 0) quot--;

        if(isPositive) return quot;
        else return -1*quot;


    }

    public int divide3(int dividend, int divisor) {
        if(dividend == 0) return 0;
        boolean isPos = true;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) isPos = false;
        int ans = 0;

        if(divisor == -2147483648){
            if(dividend == -2147483648) return 1;
            else return 0;
        }
        if(divisor == 1) return dividend;
        if(divisor == -1){
            if(dividend == -2147483648) return 2147483647;
            else return -dividend;
        }

        int leftDividend = 0;
        if(dividend == -2147483648){
            leftDividend++;
            dividend++;
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while(dividend >= divisor){
            dividend -= divisor;
            ans++;
            if(ans == 2147483647) return isPos? ans:-ans;
        }
        if(leftDividend == 1 && (dividend+1) >= divisor) ans++;
        return isPos? ans:-ans;
    }
}
