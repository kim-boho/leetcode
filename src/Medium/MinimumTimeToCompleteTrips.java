package Medium;

import java.util.Arrays;

public class MinimumTimeToCompleteTrips {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long start = 0;
        long end = ((long)time[0])*((long)totalTrips);
        while(start < end){
            if(end-start == 1){
                return end;
            }
            long mid = (start+end)/2;
            long temp = calculateTime(time, mid);
            if(temp == totalTrips){
                while(start<mid && calculateTime(time,mid) == totalTrips) mid--;
                return mid+1;
            }
            else if(temp < totalTrips){
                start = mid;
            } else{
                end = mid;
            }
        }
        return 0;
    }

    private long calculateTime(int[] time, long mid){
        long temp =0;
        for (int j : time) {
            temp += (mid / (long) j);
        }
        return temp;
    }
}
