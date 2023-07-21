package Medium;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(10, Collections.reverseOrder());
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                q.offer(matrix[i][j]);
                if(q.size()>k) q.poll();
            }
        }
        return q.poll();
    }
}
