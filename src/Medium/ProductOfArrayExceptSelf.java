package Medium;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int zeroCount = 0;
        int prod = 1;
        int zeroIdx = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                zeroCount++;
                zeroIdx = i;
            }
            else prod *= nums[i];
        }
        if(zeroCount>1) return ans;
        else if(zeroCount == 1){
            ans[zeroIdx] = prod;
        } else{
            for(int i=0; i<nums.length; i++){
                if(nums[i] != 0) ans[i] = prod/nums[i];
            }
        }
        return ans;
    }
}
