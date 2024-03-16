package Medium;

public class RemoveZeroSumConsecutiveNodesFromLinkedList {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode p = dummy;
        while(p.next != null){
            ListNode current = p.next;
            int sum = 0;
            while(current != null){
                sum += current.val;
                if(sum == 0) break;
                current = current.next;
            }
            if(sum == 0){
                p.next = current.next;
                current.next = null;
            } else p = p.next;
        }
        return dummy.next;
    }
}
