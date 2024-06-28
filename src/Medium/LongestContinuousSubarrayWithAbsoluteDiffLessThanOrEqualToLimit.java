package Medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public int longestSubarray(int[] nums, int limit) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int min = nums[0];
        int max = nums[0];
        hm.put(nums[0],0);
        int left = 0;
        int maxLen = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i]>max){
                max = nums[i];
            }
            if(nums[i]<min){
                min = nums[i];
            }
            hm.put(nums[i],i);
            if(max-min > limit){
                int nextIdx = Math.min(hm.get(max),hm.get(min));
                boolean changeMin = true;
                if(hm.get(max) < hm.get(min)){
                    changeMin = false;
                }
                while(left <= nextIdx){
                    if(hm.containsKey(nums[left]) && hm.get(nums[left])==left) hm.remove(nums[left]);
                    left++;
                }
                PriorityQueue<Integer> heap = null;
                if(changeMin){
                    heap = new PriorityQueue<>();
                    heap.addAll(hm.keySet());
                    min = heap.poll();
                } else{
                    heap = new PriorityQueue<>(Collections.reverseOrder());
                    heap.addAll(hm.keySet());
                    max = heap.poll();
                }
            }
            maxLen = Math.max(maxLen, i-left+1);
        }
        return maxLen;
    }
}
