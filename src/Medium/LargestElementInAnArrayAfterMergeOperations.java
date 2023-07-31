package Medium;

import java.util.LinkedList;

public class LargestElementInAnArrayAfterMergeOperations {
    public long maxArrayValue(int[] nums) {
        LinkedList<Long> li = new LinkedList<>();
        for(int num:nums) li.add((long)num);

        int idx = nums.length-1;
        while(idx>0){
            while(idx>0 && li.get(idx)>=li.get(idx-1)){
                li.set(idx-1, li.get(idx)+li.get(idx-1));
                li.remove(idx);
                idx--;
            }
            idx--;
        }

        long ans = 0;
        for(long num:li){
            if(ans<num) ans = num;
        }
        return ans;
    }
}
