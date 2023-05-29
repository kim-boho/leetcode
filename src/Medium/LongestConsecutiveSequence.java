package Medium;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> ts = new HashSet<>();
        for(int i:nums) ts.add(i);
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            if(ts.contains(nums[i])){
                int tempCount = 1;
                int temp = nums[i]-1;
                while(ts.contains(temp)){
                    tempCount++;
                    ts.remove(temp);
                    temp--;
                }
                temp = nums[i]+1;
                while(ts.contains(temp)){
                    tempCount++;
                    ts.remove(temp);
                    temp++;
                }
                ans = Math.max(ans, tempCount);
            }
        }

        return ans;
    }
}
