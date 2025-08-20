package Medium;

public class FlattenAMultilevelDoublyLinkedList {
    public DoublyNode flatten(DoublyNode head) {
        DoublyNode end = dfs(null,head);
        return head;
    }

    private DoublyNode dfs(DoublyNode prev, DoublyNode current){
        if(current == null) return null;
        while(current.child == null && current.next != null){
            prev = current;
            current = current.next;
        }
        if(current.next == null && current.child == null) return current;
        DoublyNode currentNext = current.next;
        current.next = current.child;
        current.child.prev = current;
        DoublyNode addedChild = dfs(current,current.child);
        current.child = null;
        if(currentNext != null) currentNext.prev = addedChild;
        if(addedChild != null) addedChild.next = currentNext;
        return dfs(current,current.next);
    }
}
class DoublyNode {
    public int val;
    public DoublyNode prev;
    public DoublyNode next;
    public DoublyNode child;
};
