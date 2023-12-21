package Easy;

public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(duration == 0) return 0;
        int start = timeSeries[0];
        int end = start+duration-1;
        int ans = 0;
        for(int i=1; i<timeSeries.length; i++){
            int t = timeSeries[i];
            if(t <= end) end = t+duration-1;
            else{
                ans += (end-start+1);
                start = t;
                end = t+duration-1;
            }
        }
        ans += (end-start+1);
        return ans;
    }
}
