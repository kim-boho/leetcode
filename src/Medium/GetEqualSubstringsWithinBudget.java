package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class GetEqualSubstringsWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {
        int ans = 0;
        int i = 0;
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        while(i < s.length()){
            int diff = Math.abs(s.charAt(i)-t.charAt(i++));
            q.add(diff);
            sum += diff;
            while(!q.isEmpty() && sum > maxCost){
                sum -= q.poll();
            }
            if(sum <= maxCost) ans = Math.max(ans,q.size());
        }
        return ans;
    }
}
