package Medium;

import java.util.Arrays;

public class DivideArrayIntoArraysWithMaxDifference {
    public int[][] divideArray(int[] nums, int k) {
        int[][] ans = new int[nums.length/3][3];
        Arrays.sort(nums);
        int pointer = 0;
        for(int i=0; i<ans.length; i++){
            int first = nums[pointer];
            for(int j=0; j<3; j++){
                if(nums[pointer]-first <= k) ans[i][j] = nums[pointer++];
                else return new int[][] {};
            }
        }
        return ans;
    }
}
