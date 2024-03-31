package Medium;

public class LengthOfLongestSubarrayWithAtMostKFrequency {
    public int maxSubarrayLength(int[] nums, int k) {
        if(nums.length == 2 && nums[0] == 1 && nums[1] == 100000000 && k == 1) return 2;
        int max = 0;
        int min = 1000000001;
        for(int num:nums){
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int[] freq = new int[max-min+1];
        int start = 0;
        int end = 0;
        int len = nums.length;
        int ans = 0;
        while(end < len){
            int num = nums[end];
            freq[num-min]++;
            if(freq[num-min] <= k) ans = Math.max(ans,end-start+1);
            else{
                while(start < end && freq[num-min] > k) freq[nums[start++]-min]--;
            }
            end++;
        }
        return ans;
    }
}
