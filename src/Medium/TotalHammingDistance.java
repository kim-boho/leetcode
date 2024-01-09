package Medium;

public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        boolean isEnd = false;
        while(!isEnd){
            int zeros = 0;
            int ones = 0;
            isEnd = true;
            for(int i=0; i<nums.length; i++){
                int n = nums[i];
                if(n != 0){
                    if(n % 2 == 0) zeros++;
                    else ones++;
                    nums[i] /= 2;
                } else zeros++;
                if(nums[i] != 0) isEnd = false;
            }
            ans += (zeros*ones);
        }
        return ans;
    }
}
