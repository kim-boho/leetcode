package Medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TheNumberOfTheSmallestUnoccupiedChair {
    public int smallestChair(int[][] times, int targetFriend) {
        int len = times.length;
        int targetArrive = times[targetFriend][0];

        int[] leaves = new int[len];
        for(int i=0; i<len; i++){
            leaves[i] = times[i][1];
        }
        Arrays.sort(times);
        Arrays.sort(leaves);
        int i=0;
        int j=0;
        int s = 0;
        PriorityQueue<Integer> empties = new PriorityQueue<>();
        PriorityQueue<int[]> seats = new PriorityQueue<>();
        while(i < len && j < len){
            while(i < len && times[i][0] < leaves[j]){
                if(!empties.isEmpty()){
                    if(times[i][0] == targetArrive) return empties.poll();
                    seats.add(new int[]{times[i][1],empties.poll()});
                } else{
                    if(times[i][0] == targetArrive) return s;
                    seats.add(new int[]{times[i][1],s++});
                }
                i++;
            }

            while(!seats.isEmpty() && seats.peek()[0] == leaves[j]){
                empties.add(seats.poll()[1]);
            }
            j++;
        }
        return -1;
    }
}
