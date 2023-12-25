package Easy;

import Medium.ListNode;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode p = head;
        ListNode prev = null;
        while(p != null){
            if(p.val == val){
                if(prev != null){
                    prev.next = p.next;
                } else{
                    head = p.next;
                }
            } else{
                prev = p;
            }
            p = p.next;
        }
        return head;
    }
}
