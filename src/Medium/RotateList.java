package Medium;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null) return head;
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            len++;
        }
        k = k % len;
        if(k == 0) return head;
        temp = head;
        while(len-k-1>0){
            k++;
            temp = temp.next;
        }

        if(temp.next == null){
            head.next = null;
            temp.next = head;
            return temp;
        }

        ListNode newHead = temp.next;
        temp.next = null;
        temp = newHead;
        while(temp != null){
            if(temp.next == null){
                temp.next = head;
                break;
            }
            else temp = temp.next;
        }

        return newHead;

    }
}
