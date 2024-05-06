package Medium;

import java.util.ArrayList;
import java.util.Stack;

public class RemoveNodesFromLinkedList {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode p = head;
        while(p != null){
            while(!st.isEmpty() && st.peek().val < p.val){
                st.pop();
            }
            if(!st.isEmpty()){
                st.peek().next = p;
            }
            st.add(p);
            p = p.next;
        }
        while(!st.isEmpty()){
            p = st.pop();
        }
        return p;
    }

    public ListNode removeNodes2(ListNode head) {
        ArrayList<ListNode> li = new ArrayList<>();
        ListNode pre = head;
        ListNode p = head.next;
        li.add(pre);
        while(p != null){
            if(p.val > pre.val){
                for(int i=li.size()-1; i>=0; i--){
                    if(p.val <= li.get(i).val){
                        li.get(i).next = p;
                        break;
                    } else{
                        li.remove(i);
                    }
                }
            }
            li.add(p);
            pre = p;
            p = p.next;
        }
        return !li.isEmpty() ? li.get(0) : null;
    }
}
