package Easy;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInAMatrix {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0; i<n; i++){
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for(int j=0; j<m; j++){
                if(min > matrix[i][j]){
                    min = matrix[i][j];
                    idx = j;
                }
            }
            int max = 0;
            int idx2 = -1;
            for(int j=0; j<n; j++){
                if(max < matrix[j][idx]){
                    max = matrix[j][idx];
                    idx2 = j;
                }
            }
            if(idx2 == i) ans.add(matrix[i][idx]);
        }
        return ans;
    }
}
