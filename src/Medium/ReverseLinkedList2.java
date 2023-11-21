package Medium;

public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;

        ListNode leftNode = head;
        ListNode rightNode = null;
        for(int i=1; i<left; i++){
            leftNode = leftNode.next;
        }

        rightNode = leftNode;
        int[] vals = new int[right-left+1];
        for(int i=0; i<vals.length; i++){
            vals[i] = rightNode.val;
            rightNode = rightNode.next;
        }

        for(int i=vals.length-1; i>=0; i--){
            leftNode.val = vals[i];
            leftNode = leftNode.next;
        }

        return head;
    }
}
