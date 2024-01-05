package Medium;

import java.util.Arrays;

public class MinimumNumberOfOperationsToMakeArrayEmpty {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            int count = 1;
            int n = nums[i++];
            while(i < nums.length && nums[i] == n){
                i++;
                count++;
            }
            if(count == 1) return -1;
            else{
                ans += count/3;
                if(count % 3 != 0) ans++;
            }
            i--;
        }
        return ans;
    }
}
