package Medium;

public class BeautifulArrangement {
    int num = 0;
    public int countArrangement(int n) {
        boolean[] checked = new boolean[n+1];
        helper(1, checked, n);
        return num;
    }

    private void helper(int depth, boolean[] checked, int n){
        if(depth > n){
            num++;
            return;
        }
        for(int i=1; i<n+1; i++){
            if(!checked[i] && (i % depth == 0 || depth % i == 0)){
                checked[i] = true;
                helper(depth+1, checked, n);
                checked[i] = false;
            }
        }
    }
}
