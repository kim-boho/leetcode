package Medium;

import java.util.LinkedList;

public class FindTheWinnerOfTheCircularGame {
    public int findTheWinner(int n, int k) {
        LinkedList<Integer> li = new LinkedList<>();
        for(int i=1; i<=n; i++) li.add(i);
        int idx = -1;
        while(li.size() > 1){
            idx = (idx+k)%n--;
            li.remove(idx--);
        }
        return li.get(0);
    }
}
