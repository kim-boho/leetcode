package Medium;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode now = head.next;
        head.next = null;
        while(now != null){
            ListNode next = now.next;
            ListNode temp = head;
            ListNode prev = null;
            while(temp != null){
                if(temp.val >= now.val){
                    now.next = temp;
                    if(prev != null) prev.next = now;
                    if(temp == head) head = now;
                    break;
                }
                prev = temp;
                temp = temp.next;
            }
            if(temp == null){
                prev.next = now;
                now.next = null;
            }
            now = next;
        }
        return head;
    }
}
