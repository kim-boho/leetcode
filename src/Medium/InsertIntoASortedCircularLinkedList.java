package Medium;

public class InsertIntoASortedCircularLinkedList {
    public Node insert(Node head, int insertVal) {
        Node newOne = new Node(insertVal);
        if(head == null){
            newOne.next = newOne;
            return newOne;
        }
        Node prev = head;
        Node n = head.next;
        if(n == null || n.next == n){
            head.next = newOne;
            newOne.next = head;
            return head;
        }
        while(n != null){
            if(head == n || (prev.val <= insertVal && n.val >= insertVal) || (prev.val > n.val && (insertVal >= prev.val || insertVal <= n.val))){
                prev.next = newOne;
                newOne.next = n;
                break;
            } else{
                prev = n;
                n = n.next;
            }
        }
        return head;
    }
}
