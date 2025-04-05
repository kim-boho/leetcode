package Medium;

public class BattleshipsInABoard {
    public int countBattleships(char[][] board) {
        int ans = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == 'X' && checkBoard(board,i,j)) ans++;
            }
        }
        return ans;
    }

    private boolean checkBoard(char[][] b, int i, int j){
        boolean isRow = false;
        boolean isCol = false;
        boolean isBtsh = true;
        b[i][j] = '.';
        if(i-1>=0 && b[i-1][j] == 'X'){
            isRow = true;
            isBtsh = checkBoard(b,i-1,j);
        }
        if(i+1<b.length && b[i+1][j] == 'X'){
            isRow = true;
            isBtsh = checkBoard(b,i+1,j);
        }
        if(j-1>=0 && b[i][j-1] == 'X'){
            isCol = true;
            isBtsh = checkBoard(b,i,j-1);
        }
        if(j+1<b[i].length && b[i][j+1] == 'X'){
            isCol = true;
            isBtsh = checkBoard(b,i,j+1);
        }
        if(!isBtsh || (isRow && isCol)) return false;
        else return true;
    }
}
