package Easy;

public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {
    public int longestMonotonicSubarray(int[] nums) {
        int len = 1;
        int ans = 0;
        int prev = nums[0];
        int flag = 0;
        for(int i=1; i<nums.length; i++){
            if(prev < nums[i]){
                if(flag >= 0){
                    len++;
                    flag = 1;
                } else {
                    ans = Math.max(ans,len);
                    len = 2;
                    flag = 1;
                }
            } else if(prev > nums[i]){
                if(flag <= 0){
                    len++;
                    flag = -1;
                } else {
                    ans = Math.max(ans,len);
                    len = 2;
                    flag = -1;
                }
            } else{
                ans = Math.max(ans,len);
                len = 1;
                flag = 0;
            }
            prev = nums[i];
        }
        ans = Math.max(ans,len);
        return ans;
    }
}
