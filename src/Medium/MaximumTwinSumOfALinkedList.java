package Medium;

import java.util.Stack;

public class MaximumTwinSumOfALinkedList {
    public int pairSum(ListNode head) {
        int ans = 0;
        if(head == null) return ans;
        int i = 0;
        ListNode p = head;
        ListNode jump = head.next;
        ListNode prev = null;
        while(jump != null){
            ListNode temp = p.next;
            p.next = prev;
            prev = p;
            p = temp;
            if(jump.next == null) break;
            jump = jump.next.next;
        }

        while(p != null){
            ans = Math.max(ans,prev.val+p.val);
            prev = prev.next;
            p = p.next;
        }
        return ans;
    }
}
