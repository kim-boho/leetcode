package Medium;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class FirstUniqueNumber {
    HashSet<Integer> notUnique;
    LinkedHashSet<Integer> unique;
    public FirstUniqueNumber(int[] nums) {
        notUnique = new HashSet<>();
        unique = new LinkedHashSet<>();
        for(int n:nums){
            if(notUnique.contains(n)){
                continue;
            } else if(unique.contains(n)){
                unique.remove(n);
                notUnique.add(n);
            } else{
                unique.add(n);
            }
        }
    }

    public int showFirstUnique() {
        while(!unique.isEmpty()){
            int n = unique.iterator().next();
            if(unique.contains(n)){
                return n;
            } else unique.remove(n);
        }
        return -1;
    }

    public void add(int value) {
        if(unique.contains(value)){
            unique.remove(value);
            notUnique.add(value);
        } else if(!notUnique.contains(value)){
            unique.add(value);
        }
    }
}
