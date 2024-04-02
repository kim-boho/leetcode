package Easy;

import java.util.Arrays;

public class CreateTargetArrayInTheGivenOrder {
    public int[] createTargetArray(int[] nums, int[] index) {
        int len = nums.length;
        int[] ans = new int[len];
        Arrays.fill(ans,-1);
        for(int i=0; i<len; i++){
            int idx = index[i];
            int num = nums[i];
            if(ans[idx] != -1) {
                int j = idx+1;
                int temp = ans[idx];
                while(j < len){
                    if(ans[j] == -1){
                        ans[j] = temp;
                        break;
                    } else{
                        int temp2 = ans[j];
                        ans[j] = temp;
                        temp = temp2;
                    }
                    j++;
                }
            }
            ans[idx] = num;
        }
        return ans;
    }
}
