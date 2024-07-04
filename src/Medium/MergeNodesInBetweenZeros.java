package Medium;

public class MergeNodesInBetweenZeros {
    public ListNode mergeNodes(ListNode head) {
        ListNode prev = null;
        ListNode p = head;
        while(p != null){
            if(p.next == null) break;
            ListNode start = p;
            p = start.next;
            int sum = 0;
            while(p.val != 0){
                sum += p.val;
                p = p.next;
            }
            start.next.val = sum;
            start.next.next = p;
            if(prev != null) prev.next = start.next;
            if(start == head) head = start.next;
            prev = start.next;
            start.next = null;
        }
        prev.next = null;
        return head;
    }
}
