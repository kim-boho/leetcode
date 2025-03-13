package Medium;

import java.util.ArrayList;

public class MaxConsecutiveOnes3 {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int len = nums.length;
        ArrayList<Integer> zeros = new ArrayList<>();
        int[] lastOnes = new int[len];
        lastOnes[len-1] = nums[len-1] == 0? -1:len-1;
        for(int i=len-2; i>=0; i--){
            if(nums[i] == 1) lastOnes[i] = lastOnes[i+1] != -1? lastOnes[i+1]:i;
            else lastOnes[i] = -1;
        }
        int[] firstOnes = new int[len];
        firstOnes[0] = 0;
        int count = 1;
        if(nums[0] == 0){
            count--;
            firstOnes[0] = -1;
            zeros.add(0);
        }
        int ans = count;
        for(int i=1; i<len; i++){
            if(nums[i] == 1){
                firstOnes[i] = firstOnes[i-1] != -1? firstOnes[i-1]:i;
                count++;
                ans = Math.max(ans,count);
            }
            else{
                count = 0;
                firstOnes[i] = -1;
                zeros.add(i);
            }
        }
        if(zeros.size() <= k) return len;
        if(k == 0) return ans;
        for(int i=k-1; i<zeros.size(); i++){
            int startIdx = zeros.get(i-k+1)-1 < 0? 0:zeros.get(i-k+1)-1;
            int endIdx = zeros.get(i)+1 >= len? len-1:zeros.get(i)+1;
            startIdx = nums[startIdx] == 0? startIdx+1:firstOnes[startIdx];
            endIdx = nums[endIdx] == 0? endIdx-1:lastOnes[endIdx];
            ans = Math.max(ans,endIdx-startIdx+1);
        }
        return ans;
    }
}
