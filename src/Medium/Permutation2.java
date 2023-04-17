package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] checked = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = new int[nums.length];
        int depth = 0;
        dfs(nums, depth, checked, ans, arr);
        return ans;
    }

    private void dfs(int[] nums, int depth, boolean[] checked, List<List<Integer>> ans, int[] arr){
        if(depth==nums.length){
            List<Integer> li = new ArrayList<>();
            for(int i: arr) li.add(i);
            ans.add(li);
        } else{
            for(int i=0; i<nums.length; i++){
                if(!checked[i]){
                    if(i == 0 || nums[i-1] != nums[i] || (nums[i] == nums[i - 1] && checked[i - 1] == true)){
                        // If it's the first element(even though it has duplicates)
                        // If it doesn't have duplicates
                        // If it's duplicate but it's added previously(its first time)

                        checked[i] = true;
                        arr[depth] = nums[i];
                        dfs(nums, depth+1, checked, ans, arr);
                        checked[i] = false;
                    }
                }
            }
        }
    }
}