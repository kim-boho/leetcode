package Medium;

import java.util.ArrayList;

public class MaximumFrequencyAfterSubarrayOperation {
    public int maxFrequency(int[] nums, int k) {
        boolean[] check = new boolean[51];
        int kCount = 0;
        for(int n:nums){
            check[n] = true;
            if(n == k) kCount++;
        }
        int[] count = new int[51];
        int ans = 0;
        for(int i=1; i<=50; i++){
            if(!check[i]) continue;
            ArrayList<Integer> li = new ArrayList<>();
            int num = 0;
            int kNum = 0;
            for(int j=0; j<nums.length; j++){
                if(nums[j] == i){
                    if(kNum > 0){
                        li.add(kNum*-1);
                        kNum = 0;
                        num = 1;
                    } else{
                        num++;
                    }
                } else if(nums[j] == k){
                    if(num != 0){
                        li.add(num);
                        num = 0;
                    }
                    kNum++;
                }
            }
            if(num != 0) li.add(num);
            else if(kNum != 0) li.add(kNum*-1);
            int[] preSum = new int[li.size()];
            preSum[0] = li.get(0);
            int maxSum = li.get(0);
            for(int j = 1; j<li.size(); j++){
                preSum[j] = Math.max(Math.max(preSum[j-1]+li.get(j),li.get(j)),0);
                maxSum = Math.max(preSum[j],maxSum);
            }
            if(i != k) maxSum += kCount;
            ans = Math.max(ans,maxSum);
        }
        return ans;
    }
}
