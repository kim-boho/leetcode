package Easy;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfMultipleArrays {
    public List<Integer> intersection(int[][] nums) {
        int[] counts = new int[1001];
        for(int[] n:nums){
            for(int i:n) counts[i]++;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=1; i<counts.length; i++){
            if(counts[i] == nums.length){
                ans.add(i);
            }
        }
        return ans;
    }
}
