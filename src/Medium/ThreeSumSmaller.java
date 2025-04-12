package Medium;

import java.util.Arrays;

public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        int ans = 0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            int sec = i+1;
            int thr = nums.length-1;
            int n = nums[i];
            while(sec < thr){
                if(n + nums[sec] + nums[thr] < target){
                    ans += (thr-sec);
                    sec++;
                } else thr--;
            }
        }
        return ans;
    }
}
