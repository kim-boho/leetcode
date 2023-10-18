package Medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList();

        for(int n:nums){
            int temp = Math.abs(n);
            if(nums[temp-1] > 0) nums[temp-1] *= -1;
            else ans.add(temp);
        }

        return ans;
    }
}
