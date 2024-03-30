package Medium;

public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
    public long countSubarrays(int[] nums, int k) {
        int len = nums.length;
        int max = 0;
        for(int i:nums){
            if(max < i) max = i;
        }
        int[] sum = new int[len];
        int idx = -1;
        if(nums[0] == max){
            sum[0]++;
            if(k==1) idx = 0;
        }
        for(int i=1; i<len; i++){
            if(nums[i] == max) sum[i]++;
            sum[i] += sum[i-1];
            if(idx == -1 && sum[i] == k) idx = i;
        }
        if(idx == -1) return 0;

        long ans = 0;
        ans += (long)(len-idx);
        for(int i=1; i<len; i++){
            int target = k+sum[i-1];
            while(idx < len && sum[idx] < target) idx++;
            if(idx < len) ans += (long)(len-idx);
        }
        return ans;
    }
}
