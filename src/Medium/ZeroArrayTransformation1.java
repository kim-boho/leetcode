package Medium;

public class ZeroArrayTransformation1 {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] total = new int[nums.length];
        for(int[] q : queries){
            total[q[0]]++;
            if(q[1]+1 < nums.length) total[q[1]+1]--;
        }
        int count = 0;
        for(int i=0; i<total.length; i++){
            count += total[i];
            if(nums[i] > count) return false;
        }
        return true;
    }
}
