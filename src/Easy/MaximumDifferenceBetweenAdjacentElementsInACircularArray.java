package Easy;

public class MaximumDifferenceBetweenAdjacentElementsInACircularArray {
    public int maxAdjacentDistance(int[] nums) {
        int ans = 0;
        for(int i=0; i<nums.length-1; i++){
            ans = Math.max(ans,nums[i]-nums[i+1]);
            ans = Math.max(ans,nums[i+1]-nums[i]);
        }
        ans = Math.max(ans,nums[0]-nums[nums.length-1]);
        ans = Math.max(ans,nums[nums.length-1]-nums[0]);
        return ans;
    }
}
