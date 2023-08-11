package Medium;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode fHead = null;
        ListNode bHead = null;
        ListNode fPointer = null;
        ListNode bPointer = null;
        ListNode pointer = head;
        while(pointer != null){
            if(pointer.val < x){
                if(fHead == null){
                    fHead = pointer;
                    fPointer = fHead;
                }
                else{
                    fPointer.next = pointer;
                    fPointer = fPointer.next;
                }
            } else{
                if(bHead == null){
                    bHead = pointer;
                    bPointer = bHead;
                }
                else{
                    bPointer.next = pointer;
                    bPointer = bPointer.next;
                }
            }
            ListNode temp = pointer;
            pointer = pointer.next;
            temp.next = null;
        }
        if(fPointer != null) fPointer.next = bHead;
        else return bHead;
        return fHead;
    }
}
