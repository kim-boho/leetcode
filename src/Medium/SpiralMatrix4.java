package Medium;

public class SpiralMatrix4 {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        boolean[][] check = new boolean[m][n];
        int[][] ans = new int[m][n];
        int r = 0;
        int c = 0;
        while(head != null){
            while(head != null && c<n && !check[r][c]){
                check[r][c] = true;
                ans[r][c] = head.val;
                c++;
                head = head.next;
            }
            c--;
            r++;
            while(head != null && r<m && !check[r][c]){
                check[r][c] = true;
                ans[r][c] = head.val;
                r++;
                head = head.next;
            }
            r--;
            c--;
            while(head != null && c>=0 && !check[r][c]){
                check[r][c] = true;
                ans[r][c] = head.val;
                c--;
                head = head.next;
            }
            c++;
            r--;
            while(head != null && r>=0 && !check[r][c]){
                check[r][c] = true;
                ans[r][c] = head.val;
                r--;
                head = head.next;
            }
            r++;
            c++;
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!check[i][j]) ans[i][j] = -1;
            }
        }
        return ans;
    }
}
