package Medium;

public class MagicSquaresInGrid {
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        if(n<3 || m<3) return ans;
        for(int i=0; i<n-2; i++){
            for(int j=0; j<m-2; j++){
                boolean[] checked = new boolean[10];

                int e00 = grid[i][j];
                if(e00<1 || e00>9 || checked[e00]) continue;
                else checked[e00] = true;
                int e01 = grid[i][j+1];
                if(e01<1 || e01>9 || checked[e01]) continue;
                else checked[e01] = true;
                int e02 = grid[i][j+2];
                if(e02<1 || e02>9 || checked[e02]) continue;
                else checked[e02] = true;
                int e10 = grid[i+1][j];
                if(e10<1 || e10>9 || checked[e10]) continue;
                else checked[e10] = true;
                int e11 = grid[i+1][j+1];
                if(e11<1 || e11>9 || checked[e11]) continue;
                else checked[e11] = true;
                int e12 = grid[i+1][j+2];
                if(e12<1 || e12>9 || checked[e12]) continue;
                else checked[e12] = true;
                int e20 = grid[i+2][j];
                if(e20<1 || e20>9 || checked[e20]) continue;
                else checked[e20] = true;
                int e21 = grid[i+2][j+1];
                if(e21<1 || e21>9 || checked[e21]) continue;
                else checked[e21] = true;
                int e22 = grid[i+2][j+2];
                if(e22<1 || e22>9 || checked[e22]) continue;
                else checked[e22] = true;

                int[] rows = new int[3];
                rows[0] = e00+e01+e02;
                rows[1] = e10+e11+e12;
                rows[2] = e20+e21+e22;
                int[] cols = new int[3];
                cols[0] = e00+e10+e20;
                cols[1] = e01+e11+e21;
                cols[2] = e02+e12+e22;
                int[] diags = new int[2];
                diags[0] = e00+e11+e22;
                diags[1] = e02+e11+e20;
                int num = rows[0];

                if(!checked[0] && num == rows[1] && num == rows[2] && num == cols[0] && num == cols[1]
                        && num == cols[2] && num == diags[0] && num == diags[1]){
                    ans++;
                }

            }
        }
        return ans;
    }
}
