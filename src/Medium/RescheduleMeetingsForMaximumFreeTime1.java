package Medium;

public class RescheduleMeetingsForMaximumFreeTime1 {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int sum = 0;
        for(int i=0; i<k; i++){
            sum += endTime[i]-startTime[i];
        }
        int ans = 0;
        int prevEnd = 0;
        for(int i=k; i<startTime.length; i++){
            ans = Math.max(ans,startTime[i]-sum-prevEnd);
            prevEnd = endTime[i-k];
            sum += endTime[i]-startTime[i];
            sum -= endTime[i-k]-startTime[i-k];
        }
        ans = Math.max(ans,eventTime-sum-prevEnd);
        return ans;
    }
}
