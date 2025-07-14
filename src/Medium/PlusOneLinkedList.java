package Medium;

public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        int newHead = update(head);
        if(newHead == 1){
            ListNode n = new ListNode(1,head);
            head = n;
        }
        return head;
    }

    private int update(ListNode node){
        if(node.next == null){
            if(node.val == 9){
                node.val = 0;
                return 1;
            }
            else{
                node.val++;
                return 0;
            }
        }
        node.val += update(node.next);
        if(node.val == 10){
            node.val = 0;
            return 1;
        }else{
            return 0;
        }
    }
}
