package Medium;

public class MyCircularDeque {
    int[] dq;
    int start;
    int size;
    public MyCircularDeque(int k) {
        dq = new int[k];
        start = 0;
        size = 0;
    }

    public boolean insertFront(int value) {
        if(size == dq.length) return false;
        if(size != 0){
            start--;
            if(start == -1) start = dq.length-1;
        }
        dq[start] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if(size == dq.length) return false;
        int last = (start+size) % dq.length;
        dq[last] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if(size == 0) return false;
        start++;
        start %= dq.length;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if(size == 0) return false;
        size--;
        return true;
    }

    public int getFront() {
        return size == 0? -1:dq[start];
    }

    public int getRear() {
        return size == 0? -1:dq[(start+size-1) % dq.length];
    }

    public boolean isEmpty() {
        return size == 0? true:false;
    }

    public boolean isFull() {
        return size == dq.length? true:false;
    }
}
