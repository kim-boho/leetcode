package Medium;

import java.util.Arrays;
import java.util.List;

public class MaximumDistanceInArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int[] nums = new int[arrays.size()*2];
        for(int i=0; i<arrays.size(); i++){
            int min = arrays.get(i).get(0);
            int max = arrays.get(i).get(arrays.get(i).size()-1);
            nums[i*2] = min;
            nums[i*2+1] = max;
        }
        Arrays.sort(nums);
        int ans = 0;
        int lastIdx = nums.length-1;
        for (List<Integer> array : arrays) {
            int min = array.get(0);
            int max = array.get(array.size() - 1);
            if (max == nums[lastIdx]) {
                ans = Math.max(ans, Math.abs(min - nums[lastIdx - 1]));
            } else ans = Math.max(ans, Math.abs(min - nums[lastIdx]));

            if (min == nums[0]) {
                ans = Math.max(ans, Math.abs(max - nums[1]));
            } else ans = Math.max(ans, Math.abs(max - nums[0]));

        }

        return ans;
    }
}
