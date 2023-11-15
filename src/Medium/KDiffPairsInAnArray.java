package Medium;

import java.util.Arrays;

public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        if(nums.length < 2) return 0;
        Arrays.sort(nums);
        int right = 1;
        int left = 0;
        int ans = 0;
        int prevLeft = nums[0];
        int prevRight = nums[1];
        while(right < nums.length){
            if(nums[right]-nums[left] == k){
                if(ans == 0 || !(prevLeft == nums[left] && prevRight == nums[right])){
                    prevLeft = nums[left];
                    prevRight = nums[right];
                    ans++;
                }
                right++;
                left++;
            } else if(nums[right]-nums[left] > k){
                left++;
                if(left == right) right++;
            } else{
                right++;
            }
        }
        return ans;
    }
}
