package Medium;

public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        while(b != 0){
            int temp1 = a^b;
            int temp2 = (a&b)<<1;
            a = temp1;
            b = temp2;
        }
        return a^b;
    }
}
