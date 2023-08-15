package Medium;

public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pos = head;
        ListNode pre = null;
        ListNode move = head;
        while(move != null){
            if(move.next != null){
                if(move.next.val != move.val){
                    pos.val = move.val;
                    pre = pos;
                    pos = pos.next;
                } else{
                    while(move.next != null && move.val == move.next.val) move = move.next;
                }
            } else{
                pos.val = move.val;
                pre = pos;
                pos = pos.next;
            }
            move = move.next;
        }
        if(pos == head) return null;
        else{
            pre.next = null;
            return head;
        }
    }
}
