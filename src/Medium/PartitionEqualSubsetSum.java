package Medium;

import java.util.ArrayList;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i:nums) sum += i;
        if(sum%2==1) return false;

        sum /= 2;
        boolean[] isReached = new boolean[sum+1];
        isReached[0] = true;
        for(int i=0; i<nums.length; i++){
            int temp = nums[i];
            ArrayList<Integer> li = new ArrayList<>();
            for(int j=0; j<=sum; j++){
                if(isReached[j]){
                    if(j+temp==sum) return true;
                    if(j+temp<=sum) li.add(j+temp);
                }
            }
            for(int num:li) isReached[num] = true;
        }
        return false;
    }
}
