package Medium;

import java.util.Stack;

public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();

        ListNode p = l1;
        while(p != null){
            s1.add(p.val);
            p = p.next;
        }
        p = l2;
        while(p != null){
            s2.add(p.val);
            p = p.next;
        }

        int add = 0;
        ListNode prev = null;
        while(s1.size() > 0 || s2.size() > 0){
            int sum = add;
            if(s1.size()>0) sum += s1.pop();
            if(s2.size()>0) sum+=s2.pop();
            ListNode temp = null;
            if(prev == null) temp = new ListNode(sum % 10);
            else temp = new ListNode(sum % 10, prev);
            add = sum / 10;
            prev = temp;
        }

        if(add == 1){
            ListNode temp = new ListNode(1, prev);
            prev = temp;
        }
        return prev;
    }
}
