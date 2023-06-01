package Easy;

import Medium.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode pointer = head;
        ListNode prev = null;
        while(pointer != null){
            ListNode nextNode = pointer.next;
            pointer.next = prev;
            prev = pointer;
            pointer = nextNode;
        }

        return prev;
    }
}
