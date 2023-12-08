package Medium;

public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int max = (int)Math.sqrt(c);
        for(int i=0; i<=max; i++){
            int j = c-i*i;
            double sqt = Math.sqrt(j);
            int sqtInt = (int) sqt;
            if((double) sqtInt == sqt) return true;
        }
        return false;
    }
}
