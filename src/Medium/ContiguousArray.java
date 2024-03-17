package Medium;

import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0) sum--;
            else sum++;
            if(sum == 0){
                ans = i+1;
            } else if(hm.containsKey(sum)){
                ans = Math.max(ans, i-hm.get(sum));
            } else{
                hm.put(sum, i);
            }
        }
        return ans;
    }
}
