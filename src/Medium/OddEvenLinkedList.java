package Medium;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode evenStart = head.next;
        ListNode oddPtr = head;
        ListNode evenPtr = head.next;
        while(oddPtr != null && evenPtr != null){
            if(oddPtr.next.next != null){
                oddPtr.next = oddPtr.next.next;
                oddPtr = oddPtr.next;
            } else break;
            if(evenPtr.next.next != null){
                evenPtr.next = evenPtr.next.next;
                evenPtr = evenPtr.next;
            } else{
                evenPtr.next = null;
                break;
            }
        }
        oddPtr.next = evenStart;
        return head;
    }
}
