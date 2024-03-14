package Medium;

import java.util.HashMap;

public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> hm = new HashMap();
        int i=0;
        int sum = 0;
        int[] preSum = new int[nums.length];
        int ans = 0;
        while(i<nums.length){
            sum += nums[i];
            preSum[i++] = sum;
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        i = 0;
        for(; i<nums.length; i++){
            int ps = preSum[i];
            int target = ps+goal;
            if(nums[i] == 1) target--;
            if(hm.containsKey(target)) ans += hm.get(target);
            hm.put(ps, hm.get(ps)-1);
        }
        return ans;
    }
}
