package Medium;

import java.util.ArrayList;

public class SwappingNodesInALinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        ArrayList<ListNode> li = new ArrayList<>();
        ListNode p = head;
        while(p != null){
            li.add(p);
            p = p.next;
        }
        int temp = li.get(k-1).val;
        li.get(k-1).val = li.get(li.size()-k).val;
        li.get(li.size()-k).val = temp;
        return head;
    }
}
