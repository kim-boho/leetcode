package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();

        int end = candidates.length-1;
        while(end >= 0 && candidates[end] > target) end--;
        if(end == -1) return ans;
        List<Integer> temp = new ArrayList<>();

        backTracking(0, 0, end, temp, ans, target, candidates);

        return ans;
    }

    private void backTracking(int sum, int start, int end,  List<Integer> temp, List<List<Integer>> ans, int target, int[] candidates){
        if(sum == target){
            ans.add(new ArrayList<>(temp));
        } else{
            for(int i=start; i<=end && sum<target; i++){
                temp.add(candidates[i]);
                backTracking(sum+candidates[i], i, end, temp, ans, target, candidates);
                temp.remove(temp.size()-1);
            }
        }
    }
}
