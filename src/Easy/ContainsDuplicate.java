package Easy;

import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num:nums){
            if(hs.contains(num)) return true;
            else hs.add(num);
        }
        return false;
    }
}
