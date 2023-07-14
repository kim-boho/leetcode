package Medium;

public class SurroundedRegions {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] checked = new boolean[n][m];

        for(int i=0; i<n; i++){
            if(board[i][0] == 'O' && !checked[i][0]) checkEdges(board, i, 0, checked);
            if(board[i][m-1] == 'O' && !checked[i][m-1]) checkEdges(board, i, m-1, checked);
        }

        for(int i=0; i<m; i++){
            if(board[0][i] == 'O' && !checked[0][i]) checkEdges(board, 0, i, checked);
            if(board[n-1][i] == 'O' && !checked[n-1][i]) checkEdges(board, n-1, i, checked);
        }

        for(int i=1; i<n-1; i++){
            for(int j=1; j<m-1; j++){
                if(board[i][j]=='O' && !checked[i][j]) board[i][j] = 'X';
            }
        }
        return;
    }

    private void checkEdges(char[][] board, int i, int j, boolean[][] checked){
        checked[i][j] = true;
        if(i-1>=0 && board[i-1][j] == 'O' && !checked[i-1][j]) checkEdges(board, i-1, j, checked);
        if(j-1>=0 && board[i][j-1] == 'O' && !checked[i][j-1]) checkEdges(board, i, j-1, checked);
        if(i+1<board.length && board[i+1][j] == 'O' && !checked[i+1][j]) checkEdges(board, i+1, j, checked);
        if(j+1<board[0].length && board[i][j+1] == 'O' && !checked[i][j+1]) checkEdges(board, i, j+1, checked);
    }
}
