package Medium;

import java.util.List;

public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList,1);
    }

    private int dfs(List<NestedInteger> nestedList, int depth){
        int ans = 0;
        for(NestedInteger ni:nestedList){
            if(ni.isInteger()) ans += ni.getInteger()*depth;
            else{
                ans += dfs(ni.getList(),depth+1);
            }
        }
        return ans;
    }
}
