package Medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

public class SortList {
    public ListNode sortList(ListNode head) {
        TreeMap<Integer, ArrayList<ListNode>> tm = new TreeMap<>();
        ListNode pointer = head;
        while(pointer != null){
            if(tm.containsKey(pointer.val)){
                tm.get(pointer.val).add(pointer);
            } else{
                ArrayList<ListNode> li = new ArrayList<>();
                li.add(pointer);
                tm.put(pointer.val, li);
            }
            pointer = pointer.next;
        }

        ListNode ans = null;
        ListNode prev = null;
        Iterator it = tm.keySet().iterator();
        while(it.hasNext()){
            int key =(int) it.next();
            if(ans == null){
                for(int i=0; i<tm.get(key).size(); i++){
                    if(i==0){
                        ans = tm.get(key).get(i);
                        prev = ans;
                    } else{
                        prev.next = tm.get(key).get(i);
                        prev = prev.next;
                    }
                }
            }
            else{
                for(int i=0; i<tm.get(key).size(); i++){
                    prev.next = tm.get(key).get(i);
                    prev = prev.next;
                }
            }
        }
        if(prev != null) prev.next = null;
        return ans;
    }
}
