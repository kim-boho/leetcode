package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList();
        Arrays.sort(nums);
        int len = nums.length;

        int[] prevIdx = new int[len];
        Arrays.fill(prevIdx, -1);
        int[] count = new int[len];
        Arrays.fill(count, 1);
        int maxIdx = 0;

        for(int i=1; i<len; i++){
            int num = nums[i];
            for(int j=i-1; j>=0; j--){
                if(num % nums[j] == 0 && count[j]+1 > count[i]){
                    prevIdx[i] = j;
                    count[i] = count[j]+1;
                }
            }
            if(count[maxIdx] < count[i]){
                maxIdx = i;
            }
        }
        while(maxIdx != -1){
            ans.add(nums[maxIdx]);
            maxIdx = prevIdx[maxIdx];
        }
        return ans;
    }
}
