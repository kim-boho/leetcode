package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class RemoveNthNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null && n != 1) return head;
        else if(head.next == null && n == 1) return null;

        Queue<ListNode> nNodes = new LinkedList<>();
        ListNode current = head;

        while(current != null){
            if(nNodes.size()>n) nNodes.poll();
            nNodes.add(current);
            current = current.next;
        }

        if(nNodes.size() == n) {
            head = head.next;
            return head;
        }

        ListNode prev = nNodes.poll();
        if(prev.next != null){
            if(prev.next.next != null) prev.next = prev.next.next;
            else prev.next = null;
        }
        return head;
    }
}
