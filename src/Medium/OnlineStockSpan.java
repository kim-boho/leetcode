package Medium;

import java.util.Stack;

public class OnlineStockSpan {
    Stack<Integer> nums;
    Stack<Integer> occs;
    public OnlineStockSpan() {
        nums = new Stack<>();
        occs = new Stack<>();
    }

    public int next(int price) {
        int count = 0;
        while(!nums.isEmpty()){
            if(nums.peek() <= price){
                nums.pop();
                count += occs.pop();
            } else break;
        }
        count++;
        nums.add(price);
        occs.add(count);
        return occs.peek();
    }
}
