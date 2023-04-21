package Hard;

import Medium.ListNode;

public class MergeSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode pointer = null;
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i=0; i<lists.length; i++){
            if(lists[i] != null && min > lists[i].val){
                min = lists[i].val;
                index = i;
            }
        }
        if(index == -1) return null;
        head = lists[index];
        lists[index] = lists[index].next;
        pointer = head;
        while(true){
            index = -1;
            min = Integer.MAX_VALUE;
            for(int i=0; i<lists.length; i++){
                if(lists[i] != null && min >= lists[i].val){
                    System.out.println(lists[i].val);
                    min = lists[i].val;
                    index = i;
                }
            }
            if(index == -1){
                break;
            } else{
                while(lists[index].next != null && lists[index].val == lists[index].next.val){
                    pointer.next = lists[index];
                    lists[index] = lists[index].next;
                    pointer = pointer.next;
                }
                pointer.next = lists[index];
                lists[index] = lists[index].next;
                pointer = pointer.next;
            }
        }

        return head;
    }
}
