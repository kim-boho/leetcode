package Easy;

import Medium.ListNode;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head.next;
        while(p2 != null){
            if(p2.next == null) return p1.next;
            p2 = p2.next;
            if(p2.next == null) return p1.next;
            p2 = p2.next;
            p1 = p1.next;
        }
        return head;
    }
}
