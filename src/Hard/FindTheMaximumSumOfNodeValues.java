package Hard;

public class FindTheMaximumSumOfNodeValues {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        long sum = 0;
        int minProfit = Integer.MAX_VALUE;
        int maxNegProfit = Integer.MIN_VALUE;
        int addCount = 0;
        for(int i=0; i<n; i++){
            int changed = nums[i]^k;
            if(changed > nums[i]){
                addCount++;
                sum += changed;
                minProfit = Math.min(minProfit, changed-nums[i]);
            } else{
                sum += nums[i];
                maxNegProfit = Math.max(changed-nums[i], maxNegProfit);
            }
        }
        return addCount % 2 == 0? sum:(minProfit + maxNegProfit > 0 ? sum + maxNegProfit : sum-minProfit);
    }
}
