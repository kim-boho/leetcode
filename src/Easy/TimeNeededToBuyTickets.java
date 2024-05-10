package Easy;

public class TimeNeededToBuyTickets {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int target = tickets[k];
        int ans = 0;
        for(int i=0; i<tickets.length; i++){
            int temp = i<=k? Math.min(tickets[i],target):Math.min(tickets[i],target-1);
            ans += temp;
        }
        return ans;
    }
}
