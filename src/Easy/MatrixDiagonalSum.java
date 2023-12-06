package Easy;

public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int r = 0;
        int c = 0;
        int ans = 0;
        while(r < n) ans += mat[r++][c++];
        r = 0;
        c--;
        while(r < n) ans += mat[r++][c--];

        if(n % 2 == 1) ans -= mat[n/2][n/2];

        return ans;
    }
}
