package Medium;

public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = {100000, -1};
        ListNode prev = head;
        ListNode p = prev.next;
        int minCP = -1;
        int count = 0;
        int prevCount = 0;
        while(p.next != null){
            if((p.next.val < p.val && prev.val < p.val) || (p.next.val > p.val && prev.val > p.val)){
                if(minCP == -1){
                    minCP = count;
                } else{
                    ans[0] = Math.min(count-prevCount,ans[0]);
                    ans[1] = count-minCP;
                }
                prevCount = count;
            }
            count++;
            prev = p;
            p = p.next;
        }
        if(ans[0] == 100000) ans[0] = -1;
        return ans;
    }
}
