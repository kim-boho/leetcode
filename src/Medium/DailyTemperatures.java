package Medium;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> monotonicStack = new Stack<>();
        int idx = temperatures.length-1;
        while(idx>=0){
            while(monotonicStack.size() > 0 && temperatures[monotonicStack.peek()] <= temperatures[idx]) monotonicStack.pop();

            if(monotonicStack.size() == 0) ans[idx] = 0;
            else ans[idx] = monotonicStack.peek() - idx;

            monotonicStack.add(idx);
            idx--;
        }
        return ans;
    }
}
