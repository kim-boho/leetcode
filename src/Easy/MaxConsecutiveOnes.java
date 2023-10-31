package Easy;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;
        int ans = 0;
        while(i<nums.length){
            if(nums[i]==1){
                int temp = 0;
                while(i<nums.length && nums[i]==1){
                    i++;
                    temp++;
                }
                if(ans<temp) ans = temp;
            }
            i++;
        }
        return ans;
    }
}
