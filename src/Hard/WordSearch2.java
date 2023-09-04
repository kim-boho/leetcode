package Hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        Trie[] arr = new Trie[26];

        for(String str:words){
            Trie prev = null;
            if(arr[str.charAt(0)-'a'] == null){
                Trie temp = new Trie(str.charAt(0));
                arr[str.charAt(0)-'a'] = temp;
            }
            prev = arr[str.charAt(0)-'a'];

            for(int i=1; i<str.length(); i++){
                if(prev.nexts[str.charAt(i)-'a'] == null){
                    Trie temp = new Trie(str.charAt(i));
                    prev.nexts[str.charAt(i)-'a'] = temp;
                }
                prev = prev.nexts[str.charAt(i)-'a'];
            }
            prev.endVal = str;
        }

        boolean[][] check = new boolean[m][n];
        HashSet<String> ans = new HashSet();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                char c = board[i][j];
                if(arr[c-'a'] != null){
                    dfs(check, i, j, arr[c-'a'], m, n, board, ans);
                }
            }
        }

        ArrayList<String> ansLi = new ArrayList(ans);
        return ansLi;
    }

    private void dfs(boolean[][] check, int i, int j, Trie current, int m, int n, char[][] board, HashSet<String> ans){
        if(current.endVal != null){
            ans.add(current.endVal);
        }

        check[i][j] = true;
        if(i-1 >= 0 && !check[i-1][j] && current.nexts[board[i-1][j]-'a'] != null){
            check[i-1][j] = true;
            dfs(check, i-1, j, current.nexts[board[i-1][j]-'a'], m, n, board, ans);
            check[i-1][j] = false;
        }
        if(i+1 < m && !check[i+1][j] && current.nexts[board[i+1][j]-'a'] != null){
            check[i+1][j] = true;
            dfs(check, i+1, j, current.nexts[board[i+1][j]-'a'], m, n, board, ans);
            check[i+1][j] = false;
        }
        if(j-1 >= 0 && !check[i][j-1] && current.nexts[board[i][j-1]-'a'] != null){
            check[i][j-1] = true;
            dfs(check, i, j-1, current.nexts[board[i][j-1]-'a'], m, n, board, ans);
            check[i][j-1] = false;
        }
        if(j+1 < n && !check[i][j+1] && current.nexts[board[i][j+1]-'a'] != null){
            check[i][j+1] = true;
            dfs(check, i, j+1, current.nexts[board[i][j+1]-'a'], m, n, board, ans);
            check[i][j+1] = false;
        }
        check[i][j] = false;
    }
}

class Trie{
    public char val;
    public Trie[] nexts;
    public boolean checked;
    public String endVal;
    public Trie(char val){
        this.val = val;
        nexts = new Trie[26];
        checked = false;
        endVal = null;
    }
}
