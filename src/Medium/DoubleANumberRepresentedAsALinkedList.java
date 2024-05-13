package Medium;

public class DoubleANumberRepresentedAsALinkedList {
    public ListNode doubleIt(ListNode head) {
        ListNode p = head;
        ListNode prev = null;
        if(p.val * 2 > 9){
            head = new ListNode(1,p);
            p.val = p.val*2-10;
        } else{
            p.val *= 2;
        }
        prev = p;
        p = p.next;
        while(p != null){
            if(p.val*2 > 9){
                prev.val++;
                p.val = p.val*2-10;
            } else{
                p.val *= 2;
            }
            prev = p;
            p = p.next;
        }
        return head;
    }
}
