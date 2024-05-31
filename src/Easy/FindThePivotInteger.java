package Easy;

public class FindThePivotInteger {
    public int pivotInteger(int n) {
        int total = n*(n+1)/2;
        int sum = 0;
        for(int i=1; i<=n; i++){
            if(total-sum == sum+i) return i;
            sum += i;
        }
        return -1;
    }
}
