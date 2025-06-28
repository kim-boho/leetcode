package Easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllKDistantIndicesInAnArray {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> li = new ArrayList<>();
        int idx = 0;
        for(int i=0; i<nums.length&&idx<nums.length; i++){
            if(nums[i] == key){
                int end = Math.max(idx,Math.min(nums.length-1,i+k));
                if(end < idx) continue;
                int start = Math.max(idx,i-k);
                while(start<=end) li.add(start++);
                idx = end+1;
            }
        }
        return li;
    }
}
