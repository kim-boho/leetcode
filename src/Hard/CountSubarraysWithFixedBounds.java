package Hard;

public class CountSubarraysWithFixedBounds {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int i = 0;
        int minIdx = -1;
        int maxIdx = -1;
        int[] nextIdx = new int[nums.length];
        for(int j=nums.length-1; j>=0; j--){
            if(nums[j] == minK){
                if(minIdx != -1) nextIdx[j] = minIdx;
                minIdx = j;
            }
            if(nums[j] == maxK){
                if(maxIdx != -1) nextIdx[j] = maxIdx;
                maxIdx = j;
            }
            if(nums[j] < minK || nums[j] > maxK){
                nextIdx[j] = -1;
            }
        }
        minIdx = -1;
        maxIdx = -1;
        int start = 0;
        long ans = 0;
        while(i < nums.length){
            if(nextIdx[i] == -1){
                i++;
                start = i;
                minIdx = -1;
                maxIdx = -1;
                continue;
            }
            if(nums[i] == minK){
                minIdx = i;
            }
            if(nums[i] == maxK){
                maxIdx = i;
            }
            if(minIdx != -1 && maxIdx != -1){
                int tempEnd = i;
                i++;
                while(i<nums.length && nextIdx[i] != -1) i++;
                for(int j=start; j<i; j++){
                    ans += i-tempEnd;
                    if(nums[j] == minK || nums[j] == maxK){
                        if (nextIdx[j] != 0 && nextIdx[j] < i){
                            tempEnd = Math.max(tempEnd, nextIdx[j]);
                        } else break;
                    }
                }
            } else i++;
        }
        return ans;
    }
}
