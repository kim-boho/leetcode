package Medium;

import java.util.ArrayList;

public class CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        ArrayList<Integer> li = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] % 2 == 1) li.add(i);
        }
        if(li.size() < k) return 0;
        int ans = 0;
        int count = 0;
        int left = 0;
        for(int i=0; i<li.size(); i++){
            count++;
            if(count == k){
                int fronts = left == 0? li.get(left): li.get(left)-li.get(left-1)-1;
                int backs = i == li.size()-1? nums.length-li.get(i)-1 : li.get(i+1)-li.get(i)-1;
                ans += (fronts*backs)+fronts+backs+1;
                count--;
                left++;
            }
        }
        return ans;
    }
}
