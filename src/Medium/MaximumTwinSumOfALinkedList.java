package Medium;

import java.util.Stack;

public class MaximumTwinSumOfALinkedList {
    public int pairSum(ListNode head) {
        int ans = 0;
        if(head == null) return ans;
        int i = 0;
        ListNode p = head;
        ListNode jump = head.next;
        Stack<Integer> st = new Stack<>();
        while(jump != null){
            st.add(p.val);
            if(jump.next == null) break;
            p = p.next;
            jump = jump.next.next;
        }
        p = p.next;
        while(p != null){
            ans = Math.max(ans,st.pop()+p.val);
            p = p.next;
        }
        return ans;
    }
}
