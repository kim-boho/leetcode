package Medium;

import java.util.LinkedList;
import java.util.List;

public class EliminationGame {
    public int lastRemaining(int n) {
        int start = 1;
        boolean startFromLeft = true;
        int step = 1;
        while(n > 1){
            if(startFromLeft || n % 2 == 1) start += step;
            step *= 2;
            n /= 2;
            startFromLeft = !startFromLeft;
        }
        return start;
    }
}
