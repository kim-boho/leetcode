package Medium;

public class RangeSumQueryMutable {
    // time fail
    int[] sum;
    public RangeSumQueryMutable(int[] nums) {
        sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            sum[i] = sum[i-1]+nums[i];
        }
    }

    public void update(int index, int val) {
        int prev = 0;
        if(index == 0){
            prev = sum[0];
        } else{
            prev = sum[index]-sum[index-1];
        }

        if(prev == val) return;

        int diff = val-prev;
        for(int i=index; i<sum.length; i++){
            sum[i] += diff;
        }
    }

    public int sumRange(int left, int right) {
        return left == 0? sum[right] : sum[right] - sum[left-1];
    }
}
