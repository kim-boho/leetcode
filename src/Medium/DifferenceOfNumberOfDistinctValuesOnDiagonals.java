package Medium;

import java.util.ArrayList;
import java.util.HashSet;

public class DifferenceOfNumberOfDistinctValuesOnDiagonals {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<m; i++){
            int r = i;
            int c = 0;
            HashSet<Integer> hs = new HashSet();
            ArrayList<Integer> li = new ArrayList();
            while(r<m && c<n){
                li.add(hs.size());
                hs.add(grid[r][c]);
                r++;
                c++;
            }
            hs = new HashSet();
            r--;
            c--;
            ArrayList<Integer> li2 = new ArrayList();
            while(r>=0 && c>=0){
                li2.add(hs.size());
                hs.add(grid[r][c]);
                r--;
                c--;
            }
            r++;
            c++;
            int idx = 0;
            int s = li2.size()-1;
            while(r<m && c<n){
                grid[r++][c++] = Math.abs(li.get(idx)-li2.get(s-idx++));
            }
        }
        for(int i=1; i<n; i++){
            int r = 0;
            int c = i;
            HashSet<Integer> hs = new HashSet();
            ArrayList<Integer> li = new ArrayList();
            while(r<m && c<n){
                li.add(hs.size());
                hs.add(grid[r][c]);
                r++;
                c++;
            }
            hs = new HashSet();
            r--;
            c--;
            ArrayList<Integer> li2 = new ArrayList();
            while(r>=0 && c>=0){
                li2.add(hs.size());
                hs.add(grid[r][c]);
                r--;
                c--;
            }
            r++;
            c++;
            int idx = 0;
            int s = li2.size()-1;
            while(r<m && c<n){
                grid[r++][c++] = Math.abs(li.get(idx)-li2.get(s-idx++));
            }
        }
        return grid;
    }
}
