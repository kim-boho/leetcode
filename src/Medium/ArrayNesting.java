package Medium;

import java.util.ArrayList;
import java.util.HashSet;

public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        int[] countArr = new int[nums.length];
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            int temp = i;
            int count = 0;
            HashSet<Integer> hs = new HashSet();
            ArrayList<Integer> li = new ArrayList();
            while(count < nums.length && !hs.contains(temp) && countArr[temp] == 0){
                hs.add(temp);
                li.add(temp);
                temp = nums[temp];
                count++;
            }
            if(count == nums.length) return count;
            int addNum = countArr[temp]+1;
            for(int j=li.size()-1; j>=0; j--){
                countArr[li.get(j)] = addNum++;
                if(j == 0 && ans < countArr[li.get(j)]) ans = countArr[li.get(j)];
            }
        }

        return ans;
    }
}
