package Medium;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
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
        grid[i][j] = '0';
        if(i-1>=0 && grid[i-1][j] == '1') checkIslands(grid, i-1, j);
        if(i+1<grid.length && grid[i+1][j] == '1') checkIslands(grid, i+1, j);
        if(j-1>=0 && grid[i][j-1] == '1') checkIslands(grid, i, j-1);
        if(j+1<grid[0].length && grid[i][j+1] == '1') checkIslands(grid, i, j+1);

        return;
    }
}
