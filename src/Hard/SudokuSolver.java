package Hard;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        dfs(board);
        return;
    }

    public boolean dfs(char[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == '.'){
                    for(char c='1'; c<='9'; c++){
                        if(isValid(board, i, j, c)){
                            board[i][j] = c;
                            if(dfs(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int i, int j, char c){
        for(int k=0; k<9; k++){
            if(board[i][k] == c) return false;
            if(board[k][j] == c) return false;
            if(board[k/3+(i/3)*3][k%3+(j/3)*3] == c) return false;
        }
        return true;
    }
}
