package Hard;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] arr = new int[n];
        backTracking(0, arr, ans);
        return ans;
    }
    private void backTracking(int depth, int[] arr, List<List<String>> ans){
        if(depth == arr.length){
            List<String> tempAns = new ArrayList<>();
            for(int i=0; i<arr.length; i++){
                StringBuilder sb = new StringBuilder("");
                for(int j=0; j<arr.length; j++){
                    if(arr[i] == j) sb.append("Q");
                    else sb.append(".");
                }
                tempAns.add(sb.toString());
            }
            ans.add(tempAns);
            return;
        }

        for(int i=0; i<arr.length; i++){
            arr[depth] = i;
            if(checkValid(arr, i, depth)){
                backTracking(depth+1, arr, ans);
            }
        }
    }

    private boolean checkValid(int arr[], int col, int depth){
        for(int i=0; i<depth; i++){
            if(arr[i] == col) return false;
            else if(arr[i] == col-depth+i || arr[i] == col+depth-i) return false;
        }
        return true;
    }
}
