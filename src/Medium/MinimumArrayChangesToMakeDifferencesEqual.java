package Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MinimumArrayChangesToMakeDifferencesEqual {
    public int minChanges(int[] nums, int k) {
        HashMap<Integer,HashSet<Integer>> diffs = new HashMap<>();
        int max = 0;
        for(int i=0; i<nums.length/2; i++){
            int diff = Math.abs(nums[i]-nums[nums.length-i-1]);
            if(diffs.containsKey(diff)) diffs.get(diff).add(i);
            else{
                HashSet<Integer> hs = new HashSet<>();
                hs.add(i);
                diffs.put(diff,hs);
            }
        }
        int ans = nums.length*2;
        int[][] keyAndCount = new int[diffs.size()][2];
        int idx = 0;
        for(int key:diffs.keySet()){
            keyAndCount[idx][0] = key;
            keyAndCount[idx++][1] = diffs.get(key).size();
        }
        Arrays.sort(keyAndCount,(a,b) -> a[1]-b[1]);
        for(int j=keyAndCount.length-1; j>=0; j--){
            int key = keyAndCount[j][0];
            if(nums.length/2 - keyAndCount[j][1] >= ans) continue;
            int temp = 0;
            boolean isPossible = true;
            HashSet<Integer> hs = diffs.get(key);
            for(int i=0; i<nums.length/2; i++){
                if(!hs.contains(i)){
                    int fir = nums[i];
                    int sec = nums[nums.length-i-1];
                    if((fir - key <= k && fir - key >= 0) || (fir + key <= k && fir + key >= 0)
                            || (sec - key <= k && sec - key >= 0) || (sec + key <= k && sec + key >= 0)){
                        temp++;
                    } else{

                        if(k >= key) temp += 2;
                        else{
                            isPossible = false;
                            break;
                        }
                    }
                }
            }
            if(isPossible) ans = Math.min(temp,ans);
        }

        return ans;
    }
}
