package Medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class DesignPhoneDirectory {
    Queue<Integer> availableNums;
    boolean[] usedNum;
    public DesignPhoneDirectory(int maxNumbers) {
        usedNum = new boolean[maxNumbers];
        availableNums = new ArrayDeque<>();
        for(int i=0; i<maxNumbers; i++) availableNums.add(i);
    }

    public int get() {
        if(availableNums.isEmpty()) return -1;
        else{
            int availableNum = availableNums.poll();
            usedNum[availableNum] = true;
            return availableNum;
        }
    }

    public boolean check(int number) {
        return !usedNum[number];
    }

    public void release(int number) {
        if(number >= usedNum.length) return;
        if(usedNum[number]) availableNums.add(number);
        usedNum[number] = false;
    }
}
