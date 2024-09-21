package Easy;

public class FindTheDistinctDifferenceArray {
    public int[] distinctDifferenceArray(int[] nums) {
        int[] total = new int[51];
        int count = 0;
        for(int n:nums){
            if(total[n] == 0) count++;
            total[n]++;
        }
        int[] pre = new int[51];
        int count2 = 0;
        int ans[] = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            total[n]--;
            if(total[n] == 0) count--;
            if(pre[n] == 0) count2++;
            pre[n]++;
            ans[i] = count2-count;
        }
        return ans;
    }
}
