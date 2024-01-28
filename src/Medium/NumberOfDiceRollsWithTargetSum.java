package Medium;

import java.util.TreeMap;

public class NumberOfDiceRollsWithTargetSum {
    public int numRollsToTarget(int n, int k, int target) {
        if(n*k < target) return 0;
        else if(n*k == target) return 1;

        TreeMap<Integer, Long> hm = new TreeMap<Integer, Long>();
        for(int i=1; i<=k; i++) hm.put(i,(long)1);

        for(int i=2; i<=n; i++){
            TreeMap<Integer, Long> temp = new TreeMap<Integer, Long>();
            for(Integer j:hm.keySet()){
                long rolls = hm.get(j);
                for(int m=1; m<=k; m++){
                    long putNum = (long)(temp.getOrDefault(m+j,(long)0)+rolls) % (1000000007);
                    temp.put(m+j, putNum);
                }
            }
            hm = temp;
        }
        return (int)(hm.get(target)%(1000000007));
    }
}
