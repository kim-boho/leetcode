package Medium;

import java.util.ArrayList;

public class ShortestPathToGetFood {
    public int getFood(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int r = 0;
        int c = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '*'){
                    r = i;
                    c = j;
                    break;
                }
            }
        }
        int ans = -1;
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();
        rows.add(r);
        cols.add(c);
        int dist = 1;
        while(!rows.isEmpty()){
            ArrayList<Integer> tempRows = new ArrayList<>();
            ArrayList<Integer> tempCols = new ArrayList<>();
            for(int i=0; i<rows.size(); i++){
                r = rows.get(i);
                c = cols.get(i);
                if(r-1 >= 0){
                    if(grid[r-1][c] == '#') return dist;
                    else if(grid[r-1][c] == 'O'){
                        grid[r-1][c] = 'C';
                        tempRows.add(r-1);
                        tempCols.add(c);
                    }
                }
                if(c-1 >= 0){
                    if(grid[r][c-1] == '#') return dist;
                    else if(grid[r][c-1] == 'O'){
                        grid[r][c-1] = 'C';
                        tempRows.add(r);
                        tempCols.add(c-1);
                    }
                }
                if(r+1 < m){
                    if(grid[r+1][c] == '#') return dist;
                    else if(grid[r+1][c] == 'O'){
                        grid[r+1][c] = 'C';
                        tempRows.add(r+1);
                        tempCols.add(c);
                    }
                }
                if(c+1 < n){
                    if(grid[r][c+1] == '#') return dist;
                    else if(grid[r][c+1] == 'O'){
                        grid[r][c+1] = 'C';
                        tempRows.add(r);
                        tempCols.add(c+1);
                    }
                }
            }
            dist++;
            rows = tempRows;
            cols = tempCols;
        }
        return ans;
    }
}
