package Medium;

public class AverageWaitingTime {
    public double averageWaitingTime(int[][] customers) {
        int curr = customers[0][0];
        long waiting = 0;
        for(int[] c:customers){
            if(curr > c[0]) waiting += curr-c[0];
            waiting += c[1];
            curr = Math.max(curr+c[1],c[0]+c[1]);
        }
        return ((double)waiting)/customers.length;
    }
}
