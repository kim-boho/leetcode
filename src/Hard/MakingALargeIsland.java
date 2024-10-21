package Hard;

import java.util.ArrayList;

public class MakingALargeIsland {
    int n;
    public int largestIsland(int[][] grid) {
        n = grid.length;
        int label = 2;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    checkIslands(grid,label,i,j);
                    label++;
                }
            }
        }
        int[] sizeOfIslands = new int[label+1];
        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] > 1){
                    sizeOfIslands[grid[i][j]]++;
                    max = Math.max(max,sizeOfIslands[grid[i][j]]);
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0){
                    int tempMax = 1;
                    ArrayList<Integer> li = new ArrayList<>();
                    if(i-1 >= 0 && grid[i-1][j] != 0){
                        tempMax += sizeOfIslands[grid[i-1][j]];
                        li.add(grid[i-1][j]);
                    }
                    if(i+1 < n && grid[i+1][j] != 0 && !li.contains(grid[i+1][j])){
                        tempMax += sizeOfIslands[grid[i+1][j]];
                        li.add(grid[i+1][j]);
                    }
                    if(j-1 >= 0 && grid[i][j-1] != 0 && !li.contains(grid[i][j-1])){
                        tempMax += sizeOfIslands[grid[i][j-1]];
                        li.add(grid[i][j-1]);
                    }
                    if(j+1 < n && grid[i][j+1] != 0 && !li.contains(grid[i][j+1])) tempMax += sizeOfIslands[grid[i][j+1]];
                    max = Math.max(max,tempMax);
                }
            }
        }
        return max;

    }

    private void checkIslands(int[][] grid, int label, int r, int c){
        grid[r][c] = label;
        if(r-1 >= 0 && grid[r-1][c] == 1) checkIslands(grid,label,r-1,c);
        if(r+1 < n && grid[r+1][c] == 1) checkIslands(grid,label,r+1,c);
        if(c-1 >= 0 && grid[r][c-1] == 1) checkIslands(grid,label,r,c-1);
        if(c+1 < n && grid[r][c+1] == 1) checkIslands(grid,label,r,c+1);
    }
}
