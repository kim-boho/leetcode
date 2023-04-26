package Hard;

import Medium.ListNode;

public class ReverseNodesinKgroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1 || head==null) return head;

        int index = 1;
        ListNode start = head;
        ListNode end = head;
        ListNode prev = null;

        while(end != null){
            if(index==k){
                ListNode temp = end.next;
                if(prev == null) head = end;
                else prev.next = end;
                prev = start;
                reverseNodes(start, end, index);
                start = temp;
                end = temp;
                index = 1;
            } else{
                if(end.next == null) break;
                end = end.next;
                index++;
            }
        }

        return head;

    }

    private void reverseNodes(ListNode start, ListNode end, int index){
        ListNode next = null;
        if(end.next != null) next = end.next;
        while(index > 0){
            ListNode temp = null;
            if(start.next != null) temp = start.next;
            start.next = next;
            next = start;
            start = temp;
            index--;
        }
        return;
    }
}
