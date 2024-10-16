package Medium;

public class DesignTicTacToe {
    int[][] board;
    int num;
    int n;
    public DesignTicTacToe(int n) {
        board = new int[n][n];
        num = 0;
        this.n = n;
    }

    public int move(int row, int col, int player) {
        board[row][col] = player;
        num++;
        if(num >= n){
            return isDone(row,col,player)? player:0;
        } else return 0;
    }

    private boolean isDone(int row, int col, int player){
        boolean isWin = true;
        for(int i=0; i<n; i++){
            if(board[i][col] != player || board[i][col] == 0){
                isWin = false;
                break;
            }
        }
        if(isWin) return true;
        isWin = true;
        for(int i=0; i<n; i++){
            if(board[row][i] != player || board[row][i] == 0){
                isWin = false;
                break;
            }
        }
        if(isWin) return true;
        isWin = true;
        for(int i=0; i<n; i++){
            if(board[i][i] != player || board[i][i] == 0){
                isWin = false;
                break;
            }
        }
        if(isWin) return true;
        isWin = true;
        for(int i=0; i<n; i++){
            if(board[i][n-i-1] != player || board[i][n-i-1] == 0){
                isWin = false;
                break;
            }
        }
        if(isWin) return true;
        else return false;
    }
}
