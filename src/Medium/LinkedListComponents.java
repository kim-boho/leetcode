package Medium;

import java.util.HashSet;

public class LinkedListComponents {
    public int numComponents(ListNode head, int[] nums) {
        int ans = 0;
        if(head == null) return ans;
        HashSet<Integer> numsSet = new HashSet<>();
        for(int n:nums) numsSet.add(n);
        boolean isComponent = numsSet.contains(head.val);
        ListNode pointer = head.next;
        while(pointer != null){
            if(!numsSet.contains(pointer.val)){
                if(isComponent) ans++;
                isComponent = false;
            } else isComponent = true;
            pointer = pointer.next;
        }
        return isComponent? ans+1:ans;
    }
}
