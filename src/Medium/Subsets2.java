package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<ArrayList<Integer>> sets = new HashSet<>();
        Arrays.sort(nums);
        int prev = -11;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != prev){
                prev = nums[i];
                ArrayList<Integer> tempAns = new ArrayList<>();
                helper(i, nums, ans, tempAns, sets);
            }
        }
        return ans;
    }

    private void helper(int start, int[] nums, List<List<Integer>> ans, ArrayList<Integer> tempAns, HashSet<ArrayList<Integer>> sets){
        if(!sets.contains(tempAns)){
            ArrayList<Integer> li = new ArrayList<>(tempAns);
            sets.add(li);
            ans.add(li);
        }
        if(start == nums.length) return;
        tempAns.add(nums[start]);
        helper(start+1, nums, ans, tempAns, sets);
        tempAns.remove(tempAns.size()-1);
        helper(start+1, nums, ans, tempAns, sets);
    }
}
