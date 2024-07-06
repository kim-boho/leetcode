package Easy;

public class SumOfAllSubsetXORTotals {
    int ans = 0;
    public int subsetXORSum(int[] nums) {
        dfs(nums, 0, 0);
        return ans;
    }

    private void dfs(int[] nums, int depth, int num){
        if(depth == nums.length){
            return;
        }

        for(int i=depth; i<nums.length; i++){
            ans += num^nums[i];
            dfs(nums, i+1, num^nums[i]);
        }
    }
}
