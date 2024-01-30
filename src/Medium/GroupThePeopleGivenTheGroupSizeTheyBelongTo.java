package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList();
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap();
        for(int i=0; i<groupSizes.length; i++){
            int groupNum = groupSizes[i];
            ArrayList<Integer> temp = hm.computeIfAbsent(groupNum, k -> new ArrayList());
            temp.add(i);
            if(temp.size() == groupNum){
                ans.add(temp);
                hm.put(groupNum, new ArrayList());
            }
        }
        return ans;
    }
}
