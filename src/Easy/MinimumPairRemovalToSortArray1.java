package Easy;

import java.util.LinkedList;

public class MinimumPairRemovalToSortArray1 {
    public int minimumPairRemoval(int[] nums) {
        LinkedList<Integer> li = new LinkedList();
        for(int n:nums) li.add(n);
        int ans = 0;
        while(li.size() > 1){
            boolean isSorted = li.get(0) <= li.get(1);
            int sum = li.get(0)+li.get(1);
            int idx = 0;
            for(int i=2; i<li.size(); i++){
                if(li.get(i) < li.get(i-1)) isSorted = false;
                if(sum > li.get(i)+li.get(i-1)){
                    idx = i-1;
                    sum = li.get(i)+li.get(i-1);
                }
            }
            if(isSorted) break;
            else{
                li.set(idx,sum);
                li.remove(idx+1);
            }
            ans++;
        }
        return ans;
    }
}
