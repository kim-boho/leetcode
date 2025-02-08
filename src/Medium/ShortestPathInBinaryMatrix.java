package Medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] != 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        dist[0][0] = 1;
        Queue<Integer> rows = new ArrayDeque<>();
        Queue<Integer> cols = new ArrayDeque<>();
        rows.add(0);
        cols.add(0);
        int path = 1;
        while(!rows.isEmpty()){
            int k = rows.size();
            while(k > 0){
                int next = path+1;
                int r = rows.poll();
                int c = cols.poll();
                for(int i=Math.max(0,r-1); i<Math.min(r+2,m); i++){
                    for(int j=Math.max(0,c-1); j<Math.min(c+2,n); j++){
                        if(grid[i][j] == 0 && (dist[i][j] == 0 || dist[i][j] > next)){
                            dist[i][j] = next;
                            rows.add(i);
                            cols.add(j);
                        }
                    }
                }
                if(dist[m-1][n-1] != 0) return dist[m-1][n-1];
                k--;
            }
            path++;
        }
        return -1;
    }
}
