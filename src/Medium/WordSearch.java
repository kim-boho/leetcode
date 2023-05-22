package Medium;

public class WordSearch {
    boolean isSearched = false;
    public boolean exist(char[][] board, String word) {
        boolean[][] checked = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length && !isSearched; i++){
            for(int j=0; j<board[i].length && !isSearched; j++){
                if(word.charAt(0) == board[i][j]) backTracking(board, word, 0, i, j, checked);
            }
        }
        return isSearched;
    }

    private void backTracking(char[][] board, String word, int depth, int row, int col, boolean[][] checked){
        if(depth == word.length()){
            isSearched = true;
        } else{
            if(word.charAt(depth) == board[row][col] && !checked[row][col]){
                checked[row][col] = true;
                if(depth == word.length()-1){
                    isSearched = true;
                    return;
                }
                if(row-1>=0) backTracking(board, word, depth+1, row-1, col, checked);
                if(row+1<board.length) backTracking(board, word, depth+1, row+1, col, checked);
                if(col-1>=0) backTracking(board, word, depth+1, row, col-1, checked);
                if(col+1<board[0].length) backTracking(board, word, depth+1, row, col+1, checked);
                checked[row][col] = false;
            }
        }
    }
}
