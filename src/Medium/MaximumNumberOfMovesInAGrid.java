package Medium;

public class MaximumNumberOfMovesInAGrid {
    public int maxMoves(int[][] grid) {
        int c = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] possible = new boolean[m][n];
        for(int i=0; i<grid.length; i++){
            possible[i][0] = true;
        }
        while(c < n){
            if(c+1 == n) break;
            boolean check = false;
            for(int i=0; i<grid.length; i++){
                if(!possible[i][c]) continue;
                int num = grid[i][c];
                if(i-1 >= 0 && grid[i-1][c+1] > num){
                    check = true;
                    possible[i-1][c+1] = true;
                }
                if(i+1 < grid.length && grid[i+1][c+1] > num){
                    check = true;
                    possible[i+1][c+1] = true;
                }
                if(grid[i][c+1] > num){
                    check = true;
                    possible[i][c+1] = true;
                }
            }
            if(!check) break;
            c++;
        }
        return c;
    }
}
