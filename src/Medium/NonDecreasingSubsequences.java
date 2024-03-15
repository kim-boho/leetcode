package Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NonDecreasingSubsequences {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    HashSet<List<Integer>> hs = new HashSet<List<Integer>>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        for(int i=0; i<nums.length; i++){
            int num1 = nums[i];
            int idx = i+1;

            while(idx < nums.length){
                if(num1 <= nums[idx]){
                    break;
                }
                idx++;
            }

            ArrayList<Integer> li = new ArrayList<>();
            if(idx < nums.length){
                li.add(num1);
                helper(nums, idx, li, num1);
            }
        }
        return ans;
    }

    private void helper(int[] nums, int start, ArrayList<Integer> li, int last){
        for(int i=start; i<nums.length; i++){
            if(nums[i] >= last){
                li.add(nums[i]);
                if(!hs.contains(li)){
                    ArrayList<Integer> temp = new ArrayList<>(li);
                    hs.add(temp);
                    ans.add(temp);
                }
                helper(nums, i+1, li, nums[i]);
                li.remove(li.size()-1);
            }
        }
    }
}
