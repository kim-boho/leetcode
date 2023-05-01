package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame3 {
    public boolean canReach(int[] arr, int start) {
        boolean[] reached = new boolean[arr.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(q.size() > 0){
            int idx = q.poll();
            if(!reached[idx]){
                int steps = arr[idx];
                if(idx-steps>=0 && !reached[idx-steps]){
                    if(arr[idx-steps] == 0) return true;
                    q.add(idx-steps);
                }

                if(idx+steps<arr.length && !reached[idx+steps]){
                    if(arr[idx+steps] == 0) return true;
                    q.add(idx+steps);
                }
            }
            reached[idx] = true;
        }
        return false;

    }
}
