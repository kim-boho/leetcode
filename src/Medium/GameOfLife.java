package Medium;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        boolean[][] isChanged = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                checkBoard(board, isChanged, i, j);
            }
        }
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(isChanged[i][j]){
                    if(board[i][j] == 0) board[i][j] = 1;
                    else board[i][j] = 0;
                }
            }
        }
    }

    private void checkBoard(int[][] board, boolean[][] isChanged, int row, int col){
        int liveNeighbor = 0;
        int n = board.length;
        int m = board[0].length;
        if(row-1>=0 && col-1>=0 && board[row-1][col-1] == 1) liveNeighbor++;
        if(row-1>=0 && board[row-1][col] == 1) liveNeighbor++;
        if(row-1>=0 && col+1<m && board[row-1][col+1] == 1) liveNeighbor++;
        if(col-1>=0 && board[row][col-1] == 1) liveNeighbor++;
        if(col+1<m && board[row][col+1] == 1) liveNeighbor++;
        if(row+1<n && col-1>=0 && board[row+1][col-1] == 1) liveNeighbor++;
        if(row+1<n && board[row+1][col] == 1) liveNeighbor++;
        if(row+1<n && col+1<m && board[row+1][col+1] == 1) liveNeighbor++;
        if(board[row][col] == 1){
            if(liveNeighbor < 2) isChanged[row][col] = true;
            else if(liveNeighbor > 3) isChanged[row][col] = true;
        } else{
            if(liveNeighbor == 3) isChanged[row][col] = true;
        }
    }
}
