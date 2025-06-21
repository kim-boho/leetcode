package Easy;

import java.util.Arrays;

public class TypeOfTriangle {
    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        if(nums[2] >= nums[0]+nums[1]) return "none";
        int s1 = nums[0];
        int s2 = -1;
        if(nums[1] != s1) s2 = nums[1];
        if(s2 == -1){
            if(nums[2] == s1) return "equilateral";
            else return "isosceles";
        } else{
            if(nums[2] == s1 || nums[2] == s2) return "isosceles";
            else return "scalene";
        }
    }
}
