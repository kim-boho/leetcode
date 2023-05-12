package Medium;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());
        boolean[] checked = new boolean[nums.length];
        for(int i=1; i<=nums.length; i++){
            dfs(0, i, checked, ans, nums, 0);
        }
        return ans;
    }

    private void dfs(int depth, int count, boolean[] checked, List<List<Integer>> ans, int[] nums, int start){
        if(depth == count){
            List<Integer> subSet = new ArrayList<>();
            for(int i=0; i<checked.length; i++){
                if(checked[i]) subSet.add(nums[i]);
            }
            ans.add(subSet);
        } else{
            for(int i=start; i<nums.length; i++){
                if(!checked[i]){
                    checked[i] = true;
                    dfs(depth+1, count, checked, ans, nums, i+1);
                    checked[i] = false;
                }
            }
        }
    }
}
