package Medium;

public class SwapNodesInPairs {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        if (head.next != null) {
            ListNode current = head;
            ListNode prev = null;
            head = head.next;
            while (current != null && current.next != null) {
                if (prev != null) prev.next = current.next;
                ListNode nextNode = current.next.next;
                current.next.next = current;
                current.next = nextNode;
                prev = current;
                current = nextNode;
            }
        }

        return head;
    }
}
