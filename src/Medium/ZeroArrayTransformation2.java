package Medium;

public class ZeroArrayTransformation2 {
    public int minZeroArray(int[] nums, int[][] queries) {
        int count = 0;
        for(int n:nums){
            if(n == 0) count++;
        }
        if(count == nums.length) return 0;
        int ans = 0;
        for(int[] q:queries){
            ans++;
            for(int i=q[0]; i<=q[1]; i++){
                if(nums[i] <= 0) continue;
                if(nums[i] > 0) nums[i] = Math.max(nums[i]-q[2],0);
                if(nums[i] == 0) count++;
            }
            if(count == nums.length) break;
        }
        return count == nums.length? ans:-1;
    }
}
