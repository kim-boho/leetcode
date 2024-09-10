package Medium;

public class InsertGreatestCommonDivisorsInLinkedList {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null) return null;
        ListNode p = head;
        while(p.next != null){
            ListNode gcd = new ListNode(gcd(p.val,p.next.val),p.next);
            p.next = gcd;
            p = gcd.next;
        }
        return head;
    }

    public int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }
}
