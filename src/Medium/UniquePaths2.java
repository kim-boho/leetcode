package Medium;

public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1] == 1 || obstacleGrid[0][0] == 1) return 0;

        boolean[][] checked = new boolean[m][n];
        int[][] paths = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(obstacleGrid[i][j] == 0 && !checked[i][j]){
                    checked[i][j] = true;
                    int path = 0;
                    if(i-1>=0 && obstacleGrid[i-1][j] == 0) path += paths[i-1][j];
                    if(j-1>=0 && obstacleGrid[i][j-1] == 0) path += paths[i][j-1];
                    if(i==0 && j==0) path++;
                    paths[i][j] = path;
                }
            }
        }
        return paths[m-1][n-1];
    }
}
