package Medium;

public class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] numOfEnemies = new int[m][n];
        for(int i=0; i<m; i++){
            int enemyCount = 0;
            int startCol = 0;
            for(int j=0; j<n; j++){
                if(grid[i][j] == 'W'){
                    if(enemyCount != 0){
                        for(int k=startCol; k<j; k++) numOfEnemies[i][k] = enemyCount;
                    }
                    enemyCount = 0;
                    startCol = j+1;
                } else if(grid[i][j] == 'E'){
                    enemyCount++;
                }
            }
            if(enemyCount != 0){
                for(int k=startCol; k<n; k++) numOfEnemies[i][k] = enemyCount;
            }
        }

        for(int j=0; j<n; j++){
            int enemyCount = 0;
            int startRow = 0;
            for(int i=0; i<m; i++){
                if(grid[i][j] == 'W'){
                    if(enemyCount != 0){
                        for(int k=startRow; k<i; k++) numOfEnemies[k][j] += enemyCount;
                    }
                    enemyCount = 0;
                    startRow = i+1;
                } else if(grid[i][j] == 'E'){
                    enemyCount++;
                }
            }
            if(enemyCount != 0){
                for(int k=startRow; k<m; k++) numOfEnemies[k][j] += enemyCount;
            }
        }

        int ans = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '0') ans = Math.max(ans,numOfEnemies[i][j]);
            }
        }
        return ans;
    }
}
