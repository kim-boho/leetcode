package Easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int n:nums)
            if(nums[Math.abs(n)-1] > 0) nums[Math.abs(n)-1] *= -1;
        List<Integer> ans = new ArrayList();
        for(int i=0; i<nums.length; i++)
            if(nums[i] > 0) ans.add(i+1);
        return ans;
    }
}
