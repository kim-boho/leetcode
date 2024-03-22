package Medium;

public class MergeInBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode p = list1;
        int i = 0;
        while(i < a-1){
            p = p.next;
            i++;
        }
        ListNode start = p;
        while(i < b){
            p = p.next;
            i++;
        }
        ListNode end = p.next;
        start.next = list2;
        p.next = null;
        p = list2;
        ListNode prev = null;
        while(p != null){
            prev = p;
            p = p.next;
        }
        prev.next = end;
        return list1;
    }
}
