package Medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class FindTheSafestPathInAGrid {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dists = new int[n][n];
        for(int[] arr:dists){
            Arrays.fill(arr,-1);
        }
        Queue<Integer> rs = new ArrayDeque<Integer>();
        Queue<Integer> cs = new ArrayDeque<Integer>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid.get(i).get(j) == 1){
                    dists[i][j] = 0;
                    rs.add(i);
                    cs.add(j);
                }
            }
        }
        while(!rs.isEmpty()){
            int r = rs.poll();
            int c = cs.poll();
            int newDis = dists[r][c]+1;
            if(r-1>=0 && dists[r-1][c] == -1){
                rs.add(r-1);
                cs.add(c);
                dists[r-1][c] = newDis;
            }
            if(r+1<n && dists[r+1][c] == -1){
                rs.add(r+1);
                cs.add(c);
                dists[r+1][c] = newDis;
            }
            if(c-1>=0 && dists[r][c-1] == -1){
                rs.add(r);
                cs.add(c-1);
                dists[r][c-1] = newDis;
            }
            if(c+1<n && dists[r][c+1] == -1){
                rs.add(r);
                cs.add(c+1);
                dists[r][c+1] = newDis;
            }
        }
        int[][] bfs = new int[n][n];
        for(int[]arr:bfs) Arrays.fill(arr,-1);
        bfs[0][0] = dists[0][0];
        rs = new ArrayDeque<Integer>();
        cs = new ArrayDeque<Integer>();
        rs.add(0);
        cs.add(0);
        while(!rs.isEmpty()){
            int r = rs.poll();
            int c = cs.poll();
            if(r-1>=0 && (bfs[r-1][c] == -1 ||  bfs[r-1][c] < Math.min(dists[r-1][c],bfs[r][c]))){
                rs.add(r-1);
                cs.add(c);
                bfs[r-1][c] = Math.min(dists[r-1][c],bfs[r][c]);
            }
            if(r+1<n && (bfs[r+1][c] == -1 ||  bfs[r+1][c] < Math.min(dists[r+1][c],bfs[r][c]))){
                rs.add(r+1);
                cs.add(c);
                bfs[r+1][c] = Math.min(dists[r+1][c],bfs[r][c]);
            }
            if(c-1>=0 && (bfs[r][c-1] == -1 ||  bfs[r][c-1] < Math.min(dists[r][c-1],bfs[r][c]))){
                rs.add(r);
                cs.add(c-1);
                bfs[r][c-1] = Math.min(dists[r][c-1],bfs[r][c]);
            }
            if(c+1<n && (bfs[r][c+1] == -1 ||  bfs[r][c+1] < Math.min(dists[r][c+1],bfs[r][c]))){
                rs.add(r);
                cs.add(c+1);
                bfs[r][c+1] = Math.min(dists[r][c+1],bfs[r][c]);
            }
        }
        return bfs[n-1][n-1];
    }
}
