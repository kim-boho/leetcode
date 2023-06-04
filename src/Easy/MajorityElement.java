package Easy;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        for(int i=0; i<=nums.length/2; i++){
            int count = 1;
            for(int j=i+1; j<nums.length; j++){
                if(nums[j] == nums[i]) count++;
            }
            if(count > nums.length/2) return nums[i];
        }
        return nums[0];
    }
}
