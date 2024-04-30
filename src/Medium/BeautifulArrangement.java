package Medium;

public class BeautifulArrangement {
    int num = 0;
    public int countArrangement(int n) {
        boolean[] checked = new boolean[n+1];
        int[] ans = new int[n+1];
        helper(1, checked, ans, n);
        return num;
    }

    private void helper(int depth, boolean[] checked, int[] ans, int n){
        if(depth > n){
            num++;
            return;
        }
        for(int i=1; i<n+1; i++){
            if(!checked[i] && (i % depth == 0 || depth % i == 0)){
                checked[i] = true;
                ans[depth] = i;
                helper(depth+1, checked, ans, n);
                checked[i] = false;
            }
        }
    }
}
