package Medium;

import java.util.HashSet;

public class DeleteNodesFromLinkedListPresentInArray {
    public ListNode modifiedList(int[] nums, ListNode head) {
        if(head == null) return head;
        HashSet<Integer> hs = new HashSet<>();
        for(int n:nums) hs.add(n);
        ListNode dummy = new ListNode(0,head);
        ListNode cur = head;
        ListNode prev = dummy;
        while(cur != null){
            if(hs.contains(cur.val)){
                prev.next = cur.next;
            } else{
                prev = prev.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
