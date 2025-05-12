package Medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] des) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        Queue<Integer> rows = new ArrayDeque<>();
        Queue<Integer> cols = new ArrayDeque<>();
        rows.add(start[0]);
        cols.add(start[1]);
        while(!rows.isEmpty()){
            int r = rows.poll();
            int c = cols.poll();
            int tempR = r;
            while(tempR-1 >= 0 && maze[tempR-1][c] == 0) tempR--;
            if(!visited[tempR][c]){
                visited[tempR][c] = true;
                rows.add(tempR);
                cols.add(c);
                if(tempR == des[0] && c == des[1]) return true;
            }
            int tempC = c;
            while(tempC-1 >= 0 && maze[r][tempC-1] == 0) tempC--;
            if(!visited[r][tempC]){
                visited[r][tempC] = true;
                rows.add(r);
                cols.add(tempC);
                if(r == des[0] && tempC == des[1]) return true;
            }
            tempR = r;
            while(tempR+1 < m && maze[tempR+1][c] == 0) tempR++;
            if(!visited[tempR][c]){
                visited[tempR][c] = true;
                rows.add(tempR);
                cols.add(c);
                if(tempR == des[0] && c == des[1]) return true;
            }
            tempC = c;
            while(tempC+1 < n && maze[r][tempC+1] == 0) tempC++;
            if(!visited[r][tempC]){
                visited[r][tempC] = true;
                rows.add(r);
                cols.add(tempC);
                if(r == des[0] && tempC == des[1]) return true;
            }
        }
        return false;
    }
}
