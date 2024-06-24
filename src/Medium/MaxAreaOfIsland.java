package Medium;

public class MaxAreaOfIsland {
    int max = 0;
    int tempMax = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 1){
                    tempMax = 0;
                    checkOnes(grid,i,j);
                }
            }
        }
        return max;
    }

    private void checkOnes(int[][] grid, int i, int j){
        tempMax++;
        grid[i][j] = 0;
        if(max<tempMax) max = tempMax;
        if(i-1>=0 && grid[i-1][j] == 1) checkOnes(grid,i-1,j);
        if(i+1<grid.length && grid[i+1][j] == 1) checkOnes(grid,i+1,j);
        if(j-1>=0 && grid[i][j-1] == 1) checkOnes(grid,i,j-1);
        if(j+1<grid[i].length && grid[i][j+1] == 1) checkOnes(grid,i,j+1);
    }
}
