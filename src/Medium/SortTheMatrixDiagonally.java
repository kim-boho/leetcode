package Medium;

import java.util.ArrayList;
import java.util.Collections;

public class SortTheMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0; i<n; i++){
            int r = 0;
            int c = i;
            ArrayList<Integer> temp = new ArrayList();
            while(r<m && c<n) temp.add(mat[r++][c++]);
            Collections.sort(temp);
            r = 0;
            c = i;
            int idx = 0;
            while(r<m && c<n) mat[r++][c++] = temp.get(idx++);
        }

        for(int i=1; i<m; i++){
            int r = i;
            int c =0;
            ArrayList<Integer> temp = new ArrayList();
            while(r<m && c<n) temp.add(mat[r++][c++]);
            Collections.sort(temp);
            r = i;
            c = 0;
            int idx = 0;
            while(r<m && c<n) mat[r++][c++] = temp.get(idx++);
        }

        return mat;
    }
}
