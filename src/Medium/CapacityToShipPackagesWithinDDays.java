package Medium;

public class CapacityToShipPackagesWithinDDays {
    int cap;
    int d;
    public int shipWithinDays(int[] weights, int days) {
        d = days;
        int sum = 0;
        int max = 0;
        for(int n:weights){
            sum += n;
            if(max < n) max = n;
        }
        cap = sum/days;
        if(sum % days != 0) cap++;
        cap = Math.max(max,cap);
        int dy = checkDays(weights);
        while(dy > days){
            dy = checkDays(weights);
        }
        return cap;
    }

    private int checkDays(int[] weights){
        int sum = 0;
        int nextCap = Integer.MAX_VALUE;
        int days = 1;
        for(int i=0; i<weights.length; i++){
            int n = weights[i];
            if(n+sum <= cap) sum += n;
            else{
                nextCap = Math.min(nextCap,sum+n);
                sum = n;
                days++;
            }
        }
        if(days > d) cap = nextCap;
        return days;
    }
}
