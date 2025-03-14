package Easy;

import java.util.HashSet;

public class TwoSum3 {
    HashSet<Integer> hs1;
    HashSet<Integer> hs2;
    public TwoSum3() {
        hs1 = new HashSet<>();
        hs2 = new HashSet<>();
    }

    public void add(int number) {
        if(!hs1.contains(number)) hs1.add(number);
        else hs2.add(number);
    }

    public boolean find(int value) {
        for(int n:hs1){
            int target = value - n;
            if(target == n && hs2.contains(target)) return true;
            else if(target != n && hs1.contains(target)) return true;
        }
        return false;
    }
}
