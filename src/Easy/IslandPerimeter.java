package Easy;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        boolean[][] checked = new boolean[grid.length][grid[0].length];
        int[] ans = new int[1];
        boolean isDone = false;
        for(int i=0; i<grid.length && !isDone; i++){
            for(int j=0; j<grid[i].length && !isDone; j++){
                if(grid[i][j] == 1){
                    helper(grid, checked, i, j, ans);
                    isDone = true;
                }
            }
        }
        return ans[0];
    }

    private void helper(int[][] grid, boolean[][] checked, int i, int j, int[] ans){
        checked[i][j] = true;
        int add = 0;
        if((i==0) || (grid[i-1][j] == 0)) add++;
        if((j==0) || (grid[i][j-1] == 0)) add++;
        if(i+1 == grid.length || grid[i+1][j] == 0) add++;
        if(j+1 == grid[0].length || grid[i][j+1] == 0) add++;

        ans[0] += add;

        if(i-1 >= 0 && grid[i-1][j] == 1 && !checked[i-1][j]) helper(grid, checked, i-1, j, ans);
        if(j-1 >= 0 && grid[i][j-1] == 1 && !checked[i][j-1]) helper(grid, checked, i, j-1, ans);
        if(i+1 < grid.length && grid[i+1][j] == 1 && !checked[i+1][j]) helper(grid, checked, i+1, j, ans);
        if(j+1 < grid[0].length && grid[i][j+1] == 1 && !checked[i][j+1]) helper(grid, checked, i, j+1, ans);
    }
}
