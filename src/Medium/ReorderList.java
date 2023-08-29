package Medium;

import java.util.ArrayList;

public class ReorderList {
    public void reorderList(ListNode head) {
        ArrayList<ListNode> arr = new ArrayList();
        ListNode temp = head;
        while(temp != null){
            arr.add(temp);
            temp = temp.next;
        }

        if(arr.size()<3) return;

        for(int i=0; i<arr.size()/2; i++){
            arr.get(i).next = arr.get(arr.size()-1-i);
            if(arr.size()-2-i > i) arr.get(arr.size()-2-i).next = null;
            if(temp != null){
                temp.next = arr.get(i);
            }
            temp = arr.get(i).next;
        }

        if(arr.size()%2 == 1){
            temp.next = arr.get(arr.size()/2);
        }

        return;
    }
}
