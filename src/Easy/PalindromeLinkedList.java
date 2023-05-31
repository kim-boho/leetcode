package Easy;

import Medium.ListNode;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        int count = 0;
        ListNode pointer = head;
        while(pointer != null){
            count++;
            pointer = pointer.next;
        }

        int count2 = 0;
        ListNode prev = null;
        pointer = head;
        while(count2 < count/2){
            ListNode temp = pointer.next;
            pointer.next = prev;
            prev = pointer;
            pointer = temp;
            count2++;
        }
        if(count % 2 == 1) pointer = pointer.next;
        while(prev != null && pointer != null){
            if(prev.val != pointer.val) return false;
            prev = prev.next;
            pointer = pointer.next;
        }
        if((prev == null && pointer != null) || (prev != null && pointer == null)) return false;
        else return true;
    }
}
