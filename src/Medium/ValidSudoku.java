package Medium;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i += 3){
            boolean[] boxCheck = new boolean[9];
            for(int j=0; j<9; j++){
                for(int k=i; k<i+3; k++){
                    if(board[k][j] != '.'){
                        if(boxCheck[board[k][j] - '1']) return false;
                        else boxCheck[board[k][j] - '1'] = true;
                    }
                }
                if(j%3==2) boxCheck = new boolean[9];
            }
        }

        for(int i=0; i<9; i++){
            boolean[] rowCheck = new boolean[9];
            boolean[] colCheck = new boolean[9];
            for(int j=0; j<9; j++){
                if(board[i][j] != '.'){
                    if(rowCheck[board[i][j]-'1']) return false;
                    else rowCheck[board[i][j]-'1'] = true;
                }
                if(board[j][i] != '.'){
                    if(colCheck[board[j][i]-'1']) return false;
                    else colCheck[board[j][i]-'1'] = true;
                }
            }
        }
        return true;
    }
}
