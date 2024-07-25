package Medium;

import java.util.Arrays;
import java.util.Comparator;

public class SortTheJumbledNumbers {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[][] arr = new int[nums.length][2];
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int n = 0;
            int temp = nums[i];
            int times = 1;
            if(temp == 0){
                n = mapping[0];
            }
            while(temp > 0){
                int digit = temp % 10;
                n += times*mapping[digit];
                times *= 10;
                temp /= 10;
            }
            arr[i][1] = i;
            arr[i][0] = n;
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        for(int i=0; i<ans.length; i++){
            ans[i] = nums[arr[i][1]];
        }
        return ans;
    }
}
