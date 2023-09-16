package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap();
        List<Integer> ans = new ArrayList();
        for(int i:nums){
            if(hm.containsKey(i)){
                hm.put(i, hm.get(i)+1);
            } else hm.put(i, 1);
            if(hm.get(i)==nums.length/3+1) ans.add(i);
        }
        return ans;
    }
}
