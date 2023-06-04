package Easy;

import Medium.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode oneJump = head;
        ListNode twoJump = head;
        while(twoJump.next != null && twoJump.next.next != null){
            if(oneJump == twoJump) return true;
            oneJump = oneJump.next;
            twoJump = twoJump.next.next;
        }
        return false;
    }
}
