package Medium;

public class CustomStack {
    int[] stack;
    int size;
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        size = 0;
    }

    public void push(int x) {
        if(size == stack.length) return;
        else{
            stack[size++] = x;
        }
    }

    public int pop() {
        if(size > 0){
            int temp = stack[size-1];
            size--;
            return temp;
        } else return -1;
    }

    public void increment(int k, int val) {
        int temp = Math.min(k,stack.length);
        temp = Math.min(size+1,temp);
        for(int i=0; i<temp; i++){
            stack[i] += val;
        }
    }
}
