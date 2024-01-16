package Easy;

import java.util.ArrayList;
import java.util.Collections;

public class TheKWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ans = new int[k];
        int idx = 0;
        ArrayList<Integer>[] nums = new ArrayList [mat[0].length+1];
        for(int i=0; i<nums.length; i++){
            nums[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<mat.length; i++){
            int count = 0;
            for(int j=0; j<mat[i].length; j++){
                if(mat[i][j] == 0) break;
                else count++;
            }
            nums[count].add(i);
        }

        for (ArrayList<Integer> li : nums) {
            Collections.sort(li);
            for (Integer integer : li) {
                ans[idx++] = integer;
                if (idx == k) break;
            }
            if (idx == k) break;
        }
        return ans;
    }

}
