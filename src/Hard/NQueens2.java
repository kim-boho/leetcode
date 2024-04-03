package Hard;

public class NQueens2 {
    int ans = 0;
    public int totalNQueens(int n) {
        int[] arr = new int[n];
        helper(arr, 0);
        return ans;
    }

    private void helper(int[] arr, int depth){
        if(depth == arr.length){
            ans++;
            return;
        }
        for(int i=0; i<arr.length; i++){
            arr[depth] = i;
            if(isValid(arr, depth, i)) helper(arr, depth+1);
        }
    }

    private boolean isValid(int[] arr, int depth, int j){
        for(int i=0; i<depth; i++){
            if(arr[i] == j) return false;
            else if(arr[i] == j-depth+i || arr[i] == j+depth-i) return false;
        }
        return true;
    }
}
