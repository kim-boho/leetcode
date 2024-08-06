package Medium;

import java.util.Arrays;

public class MinimumNumberOfPushesToTypeWord2 {
    public int minimumPushes(String word) {
        int[] nums = new int[26];
        char[] arr = word.toCharArray();
        for(char c:arr) nums[c-'a']++;
        Arrays.sort(nums);
        int[] group = {8,8,8,2};
        int i = 25;
        int j = 0;
        int ans = 0;
        while(i >= 0) {
            int n = group[j];
            while(n>0){
                if(nums[i] == 0){
                    i = -1;
                    break;
                }
                ans += nums[i--]*(j+1);
                n--;
            }
            j++;
        }
        return ans;
    }
}
