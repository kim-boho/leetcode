package Medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList();
        if(k*(k+1)/2 > n) return ans;
        else if(k*(k+1)/2 == n){ 
            List<Integer> li = new ArrayList();
            for(int i=1; i<=k; i++) li.add(i);
            ans.add(li);
            return ans;
        } else{
            int[] candidates = new int[9];
            boolean[] check = new boolean[9];
            int[] tempAns = new int[k];
            dfs(0, 0, k, n, ans, tempAns, check, 0);
            return ans;
        }
    }

    private void dfs(int start, int count, int k, int n, List<List<Integer>> ans, int[] tempAns, boolean[] check, int sum){
        if(count == k){
            if(sum != n) return;
            List<Integer> li = new ArrayList();
            for(int i: tempAns) li.add(i);
            ans.add(li);
            return;
        }

        for(int i=start; i<9; i++){
            if(!check[i]){
                check[i] = true;
                tempAns[count] = i+1;
                dfs(i+1, count+1, k, n, ans, tempAns, check, sum+i+1);
                check[i] = false;
            }
        }
    }
}
