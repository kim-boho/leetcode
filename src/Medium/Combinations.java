package Medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] combi = new int[k];
        boolean[] checked = new boolean[n];
        dfs(0, k, n, combi, checked, ans, 0);

        return ans;
    }

    private void dfs(int count, int k, int n, int[] combi, boolean[] checked, List<List<Integer>> ans, int start){
        if(count == k){
            List<Integer> temp = new ArrayList<>();
            for(int i:combi) temp.add(i);
            ans.add(temp);
            return;
        }

        for(int i=start; i<n; i++){
            if(!checked[i]){
                checked[i] = true;
                combi[count] = i+1;
                dfs(count+1, k, n, combi, checked, ans, i+1);
                checked[i] = false;
            }
        }
    }
}
