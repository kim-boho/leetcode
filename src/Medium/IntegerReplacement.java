package Medium;

public class IntegerReplacement {
    public int integerReplacement(int n) {
        return (int)helper((long)n);
    }

    private long helper(long n){
        long count = 0;
        while(n % 2 == 0){
            count++;
            n = n/2;
        }
        if(n == 1) return count;
        return count + Math.min(helper(n-1)+1, helper(n+1)+1);
    }
}
