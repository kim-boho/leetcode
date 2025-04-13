package Medium;

import java.util.ArrayList;
import java.util.List;

public class NestedListWeightSum2 {
    int maxDep = 0;
    ArrayList<Integer> nums = new ArrayList<>();
    ArrayList<Integer> deps = new ArrayList<>();
    public int depthSumInverse(List<NestedInteger> nestedList) {
        for(int i=0; i<nestedList.size(); i++){
            helper(nestedList.get(i),1);
        }
        int ans = 0;
        for(int i=0; i<nums.size(); i++){
            ans += ((maxDep-deps.get(i)+1)*nums.get(i));
        }
        return ans;
    }

    private void helper(NestedInteger nes, int dep){
        maxDep = Math.max(maxDep,dep);
        if(nes.isInteger()){
            nums.add(nes.getInteger());
            deps.add(dep);
        } else{
            List<NestedInteger> next = nes.getList();
            for (NestedInteger nestedInteger : next) {
                helper(nestedInteger, dep + 1);
            }
        }
    }
}
