package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        // slow
        int len = grid.length;
        int len2 = grid[0].length;
        int ans = 0;
        for(int i=0; i<len; i++){
            for(int j=0; j<len2; j++){
                if(grid[i][j] == '1'){
                    checkIslands(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void checkIslands(char[][] grid, int i, int j){
        Queue<int[]> pair = new LinkedList<>();
        int[] arr = {i, j};
        pair.add(arr);
        while(pair.size() > 0){
            i = pair.peek()[0];
            j = pair.peek()[1];
            if(i-1>=0 && grid[i-1][j] == '1') {
                int[] tempArr = {i-1, j};
                pair.add(tempArr);
            }
            if(i+1<grid.length && grid[i+1][j] == '1'){
                int[] tempArr = {i+1, j};
                pair.add(tempArr);
            }
            if(j-1>=0 && grid[i][j-1] == '1'){
                int[] tempArr = {i, j-1};
                pair.add(tempArr);
            }
            if(j+1<grid[0].length && grid[i][j+1] == '1'){
                int[] tempArr = {i, j+1};
                pair.add(tempArr);
            }
            grid[i][j] = '0';
            pair.poll();
        }
    }
}
