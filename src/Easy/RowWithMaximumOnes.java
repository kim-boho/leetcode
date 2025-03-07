package Easy;

public class RowWithMaximumOnes {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] ans = new int[2];
        for(int i=0; i<mat.length; i++){
            int count = 0;
            for(int n:mat[i]) count += n;
            if(count > ans[1]){
                ans[0] = i;
                ans[1] = count;
            }
        }
        return ans;
    }
}
