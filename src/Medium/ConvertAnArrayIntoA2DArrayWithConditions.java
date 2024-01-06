package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConvertAnArrayIntoA2DArrayWithConditions {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        if(nums.length == 0) return ans;
        HashMap<Integer, Integer> hm = new HashMap();
        for(int n:nums){
            if(hm.containsKey(n)) hm.put(n,hm.get(n)+1);
            else hm.put(n,1);
        }
        HashMap<Integer, ArrayList<Integer>> hm2 = new HashMap<Integer, ArrayList<Integer>>();
        for (Integer value : hm.keySet()) {
            int n = (int) value;
            if (hm2.containsKey(hm.get(n))) hm2.get(hm.get(n)).add(n);
            else {
                ArrayList<Integer> temp = new ArrayList();
                temp.add(n);
                hm2.put(hm.get(n), temp);
            }
        }

        for (Integer integer : hm2.keySet()) {
            int occ = (int) integer;
            for (int i = 0; i < hm2.get(occ).size(); i++) {
                int num = hm2.get(occ).get(i);
                for (int j = 0; j < occ; j++) {
                    if (ans.size() > j) {
                        ans.get(j).add(num);
                    } else {
                        List<Integer> li = new ArrayList();
                        li.add(num);
                        ans.add(li);
                    }
                }
            }
        }

        return ans;

    }
}
