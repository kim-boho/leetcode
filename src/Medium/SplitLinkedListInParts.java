package Medium;

public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        if(head==null) return ans;
        int n = 0;
        ListNode p = head;
        while(p != null){
            n++;
            p = p.next;
        }

        int num = n / k;
        int rem = n % k;
        p = head;

        for(int i=0; i<k; i++){
            int limit = num;
            if(rem > 0){
                limit++;
                rem--;
            }
            ListNode temp = p;
            ListNode prev = null;
            while(limit > 0 && p != null){
                limit--;
                prev = p;
                p = p.next;
            }
            ans[i] = temp;
            if(prev != null) prev.next = null;
            if(limit>0 || p == null) break;
        }
        return ans;
    }
}
