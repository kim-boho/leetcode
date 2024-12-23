package Easy;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length == 0){
            List<Integer> temp = new ArrayList<>();
            temp.add(lower);
            temp.add(upper);
            ans.add(temp);
            return ans;
        }
        int count = lower;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != count){
                List<Integer> temp = new ArrayList<>();
                temp.add(count);
                temp.add(nums[i]-1);
                count = nums[i]+1;
                ans.add(temp);
            } else count++;
        }
        if(nums[nums.length-1] < upper){
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[nums.length-1]+1);
            temp.add(upper);
            ans.add(temp);
        }
        return ans;
    }
}
