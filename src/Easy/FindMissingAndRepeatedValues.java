package Easy;

public class FindMissingAndRepeatedValues {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] ans = new int[2];
        boolean[] checked = new boolean[n*n+1];
        for(int[] g:grid){
            for(int i:g){
                if(!checked[i]) checked[i] = true;
                else{
                    ans[0] = i;
                }
            }
        }
        for(int i=1; i<=n*n; i++){
            if(!checked[i]){
                ans[1] = i;
                break;
            }
        }
        return ans;
    }
}
