package Medium;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList();
        helper(1, ans, n);
        return ans;
    }

    private void helper(int m, List<Integer> ans, int n){
        if(ans.size() == n) return;

        if(m<=n) ans.add(m);
        else return;

        if(ans.size() == n) return;

        helper(m*10, ans, n);
        for(int i=1; i<=9; i++){
            if(ans.size() == n) break;
            if(m+i <= n) ans.add(m+i);
            helper((m+i)*10, ans, n);
        }
    }
}
