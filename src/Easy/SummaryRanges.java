package Easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList();
        int i= 0;
        while(i < nums.length){
            int start = nums[i];
            int temp = i;
            while(i+1 < nums.length && nums[i]+1 == nums[i+1]) i++;
            if(temp == i) ans.add(String.valueOf(nums[i]));
            else{
                String s = String.valueOf(nums[temp])+"->"+String.valueOf(nums[i]);
                ans.add(s);
            }
            i++;
        }
        return ans;
    }
}
