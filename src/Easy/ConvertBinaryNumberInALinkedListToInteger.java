package Easy;

import Medium.ListNode;

import java.util.ArrayList;

public class ConvertBinaryNumberInALinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        ArrayList<Integer> li = new ArrayList<>();
        while(head != null){
            li.add(head.val);
            head = head.next;
        }
        int pow = 1;
        for(int i=li.size()-1; i>=0; i--){
            ans += pow*li.get(i);
            pow *= 2;
        }
        return ans;
    }
}
