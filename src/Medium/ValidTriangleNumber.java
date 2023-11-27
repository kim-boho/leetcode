package Medium;

import java.util.Arrays;

public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    int e1 = nums[i];
                    int e2 = nums[j];
                    int e3 = nums[k];
                    if(e1 + e2 > e3) ans++;
                }
            }
        }
        return ans;
    }
}
