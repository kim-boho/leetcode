package Easy;

public class RangeSumQueryImmutable {
    class NumArray {
        int[] sums;
        public NumArray(int[] nums) {
            sums = new int[nums.length];
            sums[0] = nums[0];
            for(int i=1; i<nums.length; i++){
                sums[i] = nums[i]+sums[i-1];
            }
        }

        public int sumRange(int left, int right) {
            if(left == 0) return sums[right];
            else return sums[right] - sums[left-1];
        }
    }

}
