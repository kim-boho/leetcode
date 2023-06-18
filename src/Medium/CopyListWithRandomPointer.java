package Medium;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Node ptr = head;
        Node newHead = null;
        Node prev = null;

        HashMap<Node, Node> pair = new HashMap<>();
        while(ptr != null){
            Node temp = new Node(ptr.val);
            if(newHead == null){
                newHead = temp;
                newHead.next = ptr.next;
            } else{
                prev.next = temp;
            }
            prev = temp;
            pair.put(ptr, prev);
            ptr = ptr.next;
        }

        ptr = head;
        prev = newHead;
        while(ptr != null){
            if(ptr.random != null) prev.random = pair.get(ptr.random);
            ptr = ptr.next;
            prev = prev.next;
        }

        return newHead;
    }
}
