package Medium;

public class DesignCircularQueue {
    int[] arrs;
    int f;
    int r;
    int size;
    public DesignCircularQueue(int k) {
        arrs = new int[k];
        f = 0;
        r = 0;
        size = 0;
    }

    public boolean enQueue(int value) {
        if(isFull()) return false;
        size++;
        arrs[r] = value;
        r++;
        r = r%arrs.length;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) return false;
        size--;
        f++;
        f = f%arrs.length;
        return true;
    }

    public int Front() {
        if(size == 0) return -1;
        return arrs[f];
    }

    public int Rear() {
        if(size == 0) return -1;
        return r == 0? arrs[arrs.length-1]:arrs[r-1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arrs.length? true:false;
    }
}
