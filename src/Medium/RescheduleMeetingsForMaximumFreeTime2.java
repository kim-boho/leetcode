package Medium;

public class RescheduleMeetingsForMaximumFreeTime2 {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] prefix = new int[n];
        int[] surfix = new int[n];
        int prev = 0;
        for(int i=1; i<n; i++){
            int gap = startTime[i-1]-prev;
            prefix[i] = Math.max(prefix[i-1],gap);
            prev = endTime[i-1];
        }
        prev = eventTime;
        for(int i=n-2; i>=0; i--){
            int gap = prev-endTime[i+1];
            surfix[i] = Math.max(surfix[i+1],gap);
            prev = startTime[i+1];
        }
        prev = 0;
        int ans = 0;
        for(int i=0; i<n-1; i++){
            int possible = Math.max(prefix[i],surfix[i]);
            int dist = startTime[i+1]-prev;
            int meeting = endTime[i]-startTime[i];
            if(possible >= meeting) ans = Math.max(dist,ans);
            else ans = Math.max(dist-meeting,ans);
            prev = endTime[i];
        }
        if(prefix[n-1] >= endTime[n-1]-startTime[n-1]) ans = Math.max(eventTime-prev,ans);
        else ans = Math.max(eventTime-prev-endTime[n-1]+startTime[n-1],ans);
        return ans;
    }
}
