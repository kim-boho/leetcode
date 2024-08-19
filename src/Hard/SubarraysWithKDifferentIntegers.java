package Hard;

import java.util.HashMap;

public class SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int[] nextIdx = new int[nums.length];
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=nums.length-1; i>=0; i--){
            int n = nums[i];
            if(hm.containsKey(n)){
                nextIdx[i] = hm.get(n);
                hm.put(n,i);
            } else hm.put(n,i);
        }
        hm = new HashMap<>();

        int start = 0;
        int end = 0;
        int ans = 0;
        while(end < nums.length){
            int n = nums[end];
            if(hm.containsKey(n)) hm.put(n,hm.get(n)+1);
            else hm.put(n,1);
            if(hm.size() == k){
                int tempEnd = end;
                end++;
                ans++;
                while(end < nums.length && hm.containsKey(nums[end])){
                    n = nums[end++];
                    ans++;
                    hm.put(n,hm.get(n)+1);
                }
                int i = start;
                for(; i<end; i++){
                    if(hm.get(nums[i]) == 1) hm.remove(nums[i]);
                    else hm.put(nums[i],hm.get(nums[i])-1);
                    if(nextIdx[i] != 0 && nextIdx[i]<end){
                        if(nextIdx[i] > tempEnd) tempEnd = nextIdx[i];
                        ans += end-tempEnd;
                    } else{
                        start = i+1;
                        break;
                    }
                }
            } else end++;
        }
        return ans;
    }
}
