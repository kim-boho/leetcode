package Easy;

import Medium.ListNode;

public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointer1 = headA;
        ListNode pointer2 = headB;
        int count1 = 0;
        int count2 = 0;
        while(pointer1.next != null){
            pointer1 = pointer1.next;
            count1++;
        }
        while(pointer2.next != null){
            pointer2 = pointer2.next;
            count2++;
        }

        if(pointer1 != pointer2) return null;
        else{
            pointer1 = headA;
            pointer2 = headB;
            if(count1>count2){
                for(int i=0; i<count1-count2; i++){
                    pointer1 = pointer1.next;
                }
            } else if(count1<count2){
                for(int i=0; i<count2-count1; i++){
                    pointer2 = pointer2.next;
                }
            }
            while(pointer1 != null && pointer2 != null){
                if(pointer1 == pointer2) return pointer1;
                else{
                    pointer1 = pointer1.next;
                    pointer2 = pointer2.next;
                }
            }
            return null;
        }
    }
}
