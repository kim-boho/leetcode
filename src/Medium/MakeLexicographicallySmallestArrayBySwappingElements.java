package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MakeLexicographicallySmallestArrayBySwappingElements {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[][] sorted = new int[nums.length][2];
        for(int i=0; i<nums.length; i++){
            sorted[i][0] = nums[i];
            sorted[i][1] = i;
        }
        Arrays.sort(sorted, (a, b) -> a[0]-b[0]);
        int i = 0;
        while(i < sorted.length){
            int startIdx = i;
            int max = sorted[i][0]+limit;
            ArrayList<Integer> idx = new ArrayList<>();
            while(i < sorted.length && sorted[i][0] <= max){
                max = sorted[i][0]+limit;
                idx.add(sorted[i][1]);
                i++;
            }
            Collections.sort(idx);
            for(int index:idx){
                nums[index] = sorted[startIdx++][0];
            }
        }
        return nums;
    }
}
